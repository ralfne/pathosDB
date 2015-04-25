/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import classes.TaxNodesWrapper.Rank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class HostCollection extends ArrayList<Host> {
    private Species m_Parasite=null;
    
    public HostCollection(Species parasite){
        m_Parasite=parasite;
    }
    
    public boolean containsRawText(String s){
        Iterator<Host> iter=this.iterator();
        while(iter.hasNext()){
            Host h=iter.next();
            String hRawText=h.getRawText().toUpperCase();
            if(hRawText.equals(s.toUpperCase())){
                return true;
            }
        }
        return false;
    }
        
    public void removeByID(int id){
        for(int i=0;i<this.size();i++){
            if(this.get(i).getID()==id){
                this.remove(i);
                break;
            }
        }
    }
    
    public Host createHost(String hostText){
        Host h=new Host(hostText, m_Parasite);
        return h;
    }
    
    public Host getByTaxID(int taxID){
        Iterator<Host> iter=this.iterator();
        while(iter.hasNext()){
            Host h=iter.next();
            if(h.getTaxID()==taxID){
                return h;
            }
        }
        return null;
    }
    
    public Host getByRawText(String text){
        Iterator<Host> iter=this.iterator();
        while(iter.hasNext()){
            Host h=iter.next();
            if(h.getRawText().equals(text)){
                return h;
            }
        }
        return null;
    }
    
    public boolean addHost(Host h){
        if(!this.contains(h)){
            this.add(h);
            return true;
        }
        return false;
    }
    
    public void initTaxPathAndTaxInfo(classes.TaxNodesWrapper tnw, Rank selectRank){
        Iterator<Host> iter=this.iterator();
        while(iter.hasNext()){
            Host h=iter.next();
            if(h.getTaxID()!=null){
                String tPath=tnw.getTaxonomyPath(h.getTaxID());
                h.setTaxPath(tPath);

                ArrayList<Integer> taxa=new ArrayList<Integer>();
                taxa=tnw.getTaxonomyComponent_TaxID(h.getTaxID(), taxa);

                Iterator<Integer> iterH=taxa.iterator();
                while(iterH.hasNext()){
                    Integer taxID=iterH.next();
                    Rank r=tnw.getRank(taxID);
                    if(r==selectRank){
                        h.setTaxInfo(tnw.getName(taxID));
                        break;
                    }
                }                
            }
        }
    }
            
    
//    public void save(Connection con)throws Exception{
//        //Reset IDs, ie existing hosts will be saved as ne ones
//        resetIDs();
//        //deleting all hosts for this parasite species
//        delete(con);
//        //...and saving all (new and existing) hosts as new hosts
//        Iterator<Host> iter=this.iterator();
//        while(iter.hasNext()){
//            Host h=iter.next();
//            h.save(con);
//        }
//    }
  
    public void resetIDs(){
        Iterator<Host> iter=this.iterator();
        while(iter.hasNext()){
            Host h=iter.next();
            h.setID(-1);
        }
    }
    
    public void delete(Connection con) throws Exception{
        String sql="DELETE FROM host WHERE ParasiteSpeciesID=" + String.valueOf(m_Parasite.getID());
        Statement st=con.createStatement();
        st.execute(sql);
        st.close();
    }
    
    public void loadForParasite(Connection con)throws Exception{
        String sql="SELECT * FROM host WHERE ParasiteSpeciesID=" + String.valueOf(m_Parasite.getID());
        load(sql, con);
    }

    public void loadForTaxInference(int limit, Connection con)throws Exception{
        String sql="SELECT * FROM host WHERE TaxID IS NULL LIMIT " + String.valueOf(limit);
        load(sql, con);
    }
    
    public void deleteTaxIDs(Connection con)throws Exception{
        String sql="UPDATE host SET TaxID=NULL";
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    
    public void updateTaxIDForRawTextLKE(String rawText, int taxID, boolean case_sensitive, Connection con)throws Exception{
        String sql="UPDATE host";
        sql+=" SET TaxID=" + String.valueOf(taxID);
        sql+=" WHERE TaxID IS NULL AND RawText";
        if(case_sensitive){
            sql+=" COLLATE utf8_bin";
        }
        sql+=" LIKE \"" + rawText + "\"";
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
    }

    public void loadDistinctHostsWithTaxID(Connection con)throws Exception{
        String sql="SELECT DISTINCT TaxID FROM host WHERE TaxID IS NOT NULL";
        load(sql, true, con);
    }
    
    private void load(String sql , Connection con)throws Exception{
        load(sql, false, con);
    }
    
    private void load(String sql, boolean taxIDsonly , Connection con)throws Exception{
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);
        while(res.next()){
            Host h=new Host(this, m_Parasite);
            if(taxIDsonly){
                h.loadTaxIDOnly(res);
            }else{
                h.load(res);
            }
            boolean added=addHost(h);
            if(!added){
                throw new Exception("Host RawText duplicated (HostCollection.loadForParasite)");
            }
        }
        res.close();
        st.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class SpeciesCollection extends HashMap<Integer, Species> {

    public void addSpeciesCollection(SpeciesCollection speciesCol) throws Exception{
        Iterator<Integer> iter=speciesCol.keySet().iterator();
        while(iter.hasNext()){
            Species s=speciesCol.get(iter.next());
            Integer taxID=s.getTaxID();
            if(this.get(taxID)==null){
                this.addSpecies(s);
            }
        }
    }
    
    public SpeciesCollection getFilterByTaxGroup(int taxGroupID, classes.TaxNodesWrapper taxnodes)throws Exception{
        SpeciesCollection filteredSpecies=new SpeciesCollection();
        Iterator<Integer> iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer key=iter.next();
            Species s=this.get(key);
            ArrayList<Integer> taxPath=new ArrayList<Integer>();
            taxPath=taxnodes.getTaxonomyComponent_TaxID(s.getTaxID(),taxPath);
            if(taxPath.contains(taxGroupID))filteredSpecies.addSpecies(s);
        }
        return filteredSpecies;
        //no tax information for : taxid=501325
    }
    
    public HashMap<String,Species> getForSpeciesNames(){
        HashMap<String,Species> out=new HashMap<String, Species>();
        Iterator<Integer> iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer key=iter.next();
            Species s=this.get(key);
            Species outSpecies=out.get(s.getName());
            if(outSpecies==null){
                out.put(s.getName(), s);
            }
        }
        return out;
    }

    public Species getByIndex(int index){
        Object[] o=this.keySet().toArray();
        int key=(Integer)o[index];
        return this.get(key);
    }
    
    public void load(Connection con)throws Exception{
        String sql="SELECT * FROM species";
        loadSpeciesFromSQL(con, sql);
    }

    public void load
            (String name,boolean useValidationID, Integer validationID, 
            Date from, Date to, Species.ParasiteType pt, boolean useParasiteType, Connection con)throws Exception{
        String sql="SELECT * FROM species WHERE Name LIKE \"";
        sql+=name + "\"";
        if(useParasiteType){
            sql+= "AND ParasiteType=" + String.valueOf(Species.getParasiteTypeAsNumber(pt));
        }
        if(useValidationID){
            sql+=" AND ValidationID ";
            if(validationID==null){
                sql+=" IS NULL";
            }else{
                sql+="=" + String.valueOf(validationID);
            }            
        }
        if(from!=null){
            String fromS = SpeciesCollection.getDateAsString(from);
            String toS = SpeciesCollection.getDateAsString(to);
            sql+=" AND CreatedDate BETWEEN \"" + fromS + "\" AND \"" + toS +"\"";
        }
        loadSpeciesFromSQL(con, sql);
    }
    
    public static void resetIsExported(Connection con) throws Exception{
        String sql="UPDATE species SET IsExported=0";
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    
    public void loadParasiteSpeciesWithoutExport(Connection con) throws Exception{
        String sql="SELECT * FROM species WHERE ParasiteType=4 AND IsExported = 0";
        loadSpeciesFromSQL(con, sql);
    }
     
    public void loadSpeciesWithoutHostInformation(Connection con) throws Exception{
        String sql="SELECT * FROM species WHERE ParasiteType=0 AND ValidationID IS NULL";
        loadSpeciesFromSQL(con, sql);
    }    

    private void loadSpeciesFromSQL(Connection con, String sql) throws Exception{
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);
        while(res.next()){
            Species s=new Species();
            s.load(res);
            this.addSpecies(s);
        }
        res.close();
        st.close();
    }
    
    public void loadParasitesForHost(int hostTaxID, Connection con)throws Exception{
        String sql="SELECT * FROM Species WHERE ID IN "
                + "(SELECT DISTINCT ParasiteSpeciesID FROM host WHERE TaxID=" 
                + String.valueOf(hostTaxID) + ")";
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);
        while(res.next()){
            Species s=new Species();
            s.load(res);
            this.addSpecies(s);
        }
    }

    public void addSpecies(Species s)throws Exception{
        if(s.getTaxID()==null)throw new Exception("Species without taxID");
        this.put(s.getTaxID(), s);
    }
    
    public static void setSpeciesToParasiteManually
            (ArrayList<Integer> taxIDs, Species.ParasiteType toType , Validation manualValidation, 
            boolean overrideManualValidation, Connection con) throws Exception{
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        names.add("ParasiteType");
        values.add(String.valueOf(Species.getParasiteTypeAsNumber(toType)));
        names.add("ValidationID");
        //values.add(String.valueOf(v.getID()));
        values.add(String.valueOf(manualValidation.getID()));
        
        String sql=SpeciesCollection.getUPDATEsql(null,"species", names, values);
        sql+=" WHERE TaxID IN (";
        sql+=getArrayAsCSVString(taxIDs);
        sql+=") ";
        //sql+=" AND ParasiteType=0";
        if(!overrideManualValidation){
            sql+=" AND (ValidationID IS NULL OR ValidationID<>" + String.valueOf(manualValidation.getID()) + ")";
        }
        
        Statement st=con.createStatement();
        st.execute(sql);
        st.close();
        
    }
    
    private static String getArrayAsCSVString(ArrayList<Integer> taxIDs){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<taxIDs.size();i++){
            if(i!=0){
                sb.append(",");
            }
            sb.append(taxIDs.get(i));
        }
        return sb.toString();
    }
    
    public static String getINSERTsql(String tableName, ArrayList<String> names, ArrayList<String> values){
        String sql="INSERT INTO " + tableName + " (";
        for(int i=0;i<names.size();i++){
            if(i>0)sql+=",";
            sql+="`" + names.get(i) + "`";
        }
        sql+=") VALUES (";
        for(int i=0;i<values.size();i++){
            if(i>0)sql+=",";
            sql+=values.get(i);
        }
        sql+=")";
        return sql;
    }
    
    public static String getUPDATEsql(Integer id, String tableName, ArrayList<String> names, ArrayList<String> values){
        String sql="UPDATE " + tableName + " SET ";
        for(int i =0;i<names.size();i++){
            if(i>0){
                sql+=",";
            }
            sql+= "`" + names.get(i) + "`=" + values.get(i);
        }
        if(id!=null){
            sql+=" WHERE ID="  + String.valueOf(id);
        }
        return sql;
    }
    
    public void writeTaxIDAndSpeciesNames(BufferedWriter bw)throws Exception{
        Iterator<Integer>iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer key=iter.next();
            Species species=this.get(key);
            species.writeTaxIDAndSpeciesNames(bw);
//            bw.write(String.valueOf(species.getTaxID()));
//            bw.write("\t");
//            bw.write(species.getName());
//            bw.newLine();
        }
    }
    
    public static String getDateAsString(Date d){
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        return s;
    }

}


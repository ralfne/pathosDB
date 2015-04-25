/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class GiNumberCollection extends ArrayList<GiNumber> {
    private Species m_Species=null;
    
    public GiNumberCollection(Species s){
        m_Species=s;
    }
    
    public Species getSpecies(){return m_Species;}
    
    public void importFromStrings(ArrayList<String> giNumberCol){
        Iterator<String> iter=giNumberCol.iterator();
        while(iter.hasNext()){
            String giNumberS=iter.next();
            GiNumber giNumber=new GiNumber(this);
            giNumber.setValue(giNumberS);
            this.add(giNumber);
        }
    }
    
    public void delete(Connection con) throws Exception{
        Statement st = con.createStatement();
        String s="DELETE FROM ginumber WHERE SpeciesID=";
        s+=String.valueOf(m_Species.getID());
        st.execute(s);
        st.close();
    }
    
    public void save(Connection con) throws Exception{
        Iterator<GiNumber> iter=this.iterator();
        while(iter.hasNext()){
            GiNumber giN=iter.next();
            giN.save(con);
        }
    }
    
    public void load(Connection con)throws Exception{
        String sql="SELECT * FROM ginumber WHERE SpeciesID=" + String.valueOf(m_Species.getID());
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);
        while(res.next()){
            GiNumber giN=new GiNumber(this);
            giN.setID(res.getInt("ID"));
            giN.setValue(res.getString("GiNumber"));
            this.add(giN);
        }
        res.close();
        st.close();
    }
}

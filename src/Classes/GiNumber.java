/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ralfne
 */
public class GiNumber {
    private int m_ID=0;
    private String m_Value="";
    private GiNumberCollection m_Parent=null;
    private Host m_Host=null;
    
    public GiNumber(GiNumberCollection parent){
        m_Parent=parent;
    }
    
    public String getValue(){return m_Value;}
    public int getID(){return m_ID;}
    public void setID(int value){m_ID=value;}
    public void setValue(String value){m_Value=value;}
    public Host getHost(){return m_Host;}
    public void setHost(Host h){m_Host=h;}

    public String toString(){return m_Value;}
    
    public void save(Connection con)throws Exception{
        String s="INSERT INTO ginumber (`SpeciesID`, `GiNumber`) VALUES (";
        s+=String.valueOf(m_Parent.getSpecies().getID());
        s+="," + m_Value + ")";
        Statement st=con.createStatement();
        int i=st.executeUpdate(s, Statement.RETURN_GENERATED_KEYS);
        ResultSet res= st.getGeneratedKeys();        
        boolean x=res.first();
        m_ID=res.getInt(1);
        res.close();
        st.close();
    }
    
    public void saveHostID(Connection con) throws Exception{
        if(m_Host!=null){
            String s="UPDATE ginumber SET HostID=" + String.valueOf(m_Host.getID());
            s+=" WHERE ID=" + String.valueOf(m_ID);
            Statement st=con.createStatement();
            st.executeUpdate(s);
            st.close();
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.frmMain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ralfne
 */
public class Host {
    private int m_ID=-1;
    private String m_RawText="";
    private Species m_Parasite=null;
    private Integer m_TaxID=null;
    private HostCollection m_Parent=null;
    private String m_TaxPath="";
    private String m_TaxInfo="";

    public String toString(){
        return m_RawText;
    }
    
    protected Host(HostCollection parent, Species parasite){
        m_Parent=parent;
        m_Parasite=parasite;
    }
    
    public Host(String rawText, Species parasite){
        m_RawText=rawText;
        m_Parasite=parasite;
    }
    
    public int getID(){return m_ID;}
    public String getRawText(){return m_RawText;}
    public String getTaxInfo(){return m_TaxInfo;}
    public String getTaxPath(){return m_TaxPath;}
    public Integer getTaxID(){return m_TaxID;}
    
    public void setTaxID(Integer value){m_TaxID=value;}
    public void setTaxInfo(String value){m_TaxInfo=value;}
    public void setTaxPath(String value){m_TaxPath=value;}
    
    protected void load(ResultSet res)throws Exception{
        m_ID=res.getInt("ID");
        m_RawText=res.getString("RawText");
        m_TaxID=res.getInt("TaxID");
        if(res.wasNull()){
            m_TaxID=null;
        }
    }
    
    protected void loadTaxIDOnly(ResultSet res)throws Exception{
        m_TaxID=res.getInt("TaxID");
    }
    
    public void setID(int value){
        m_ID=value;
    }
    
    public void save(Connection con)throws Exception{
        if(m_ID<0){
            insert(con);
        }
    }
    
    public static void deleteHost(int id, Connection con)throws Exception{
        String sqlGiNumber="DELETE FROM ginumber WHERE HostID=" + String.valueOf(id);
        String sqlHost="DELETE FROM host WHERE ID=" + String.valueOf(id);
        Statement st=null;        
        
        try {
            con.setAutoCommit(false);
            st=con.createStatement();
            st.execute(sqlGiNumber);
            st=con.createStatement();
            st.execute(sqlHost);
        } catch (SQLException e ) {
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                    throw (e);
                } catch(SQLException excep) {
                    frmMain.getfrmMain().displayException(excep);
                }
            }
        } finally {
            if (st != null) {st.close(); }
        con.setAutoCommit(true);
        }
    }
    
    private void insert(Connection con)throws Exception{
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        
        names.add("ParasiteSpeciesID");
        values.add(String.valueOf(m_Parasite.getID()));
        
        names.add("RawText");
        values.add("\"" + m_RawText + "\"");
        
        if(m_TaxID!=null){
            names.add("TaxID");
            values.add(String.valueOf(m_TaxID));
        }
        
        String s=SpeciesCollection.getINSERTsql("host", names, values);
        
        Statement st=con.createStatement();
        int tmp=st.executeUpdate(s, Statement.RETURN_GENERATED_KEYS);
        ResultSet res= st.getGeneratedKeys();        
        boolean x=res.first();
        m_ID=res.getInt(1);
        res.close();
        st.close();   
    }
    
    public void updateTaxID(Connection con)throws Exception{
        String sql="UPDATE host SET TaxID=" + String.valueOf(m_TaxID);
        sql+=" WHERE ID=" + String.valueOf(m_ID);
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    
}

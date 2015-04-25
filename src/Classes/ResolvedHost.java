/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import classes.TaxNodesImporter.TaxNode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ralfne
 */
public class ResolvedHost {
    private int m_TaxID =-1;
    private String m_TaxName=null;
    private HashMap<String, String> m_RawTexts=new HashMap<String, String>();
    private SpeciesCollection m_Parasites=new SpeciesCollection();
    
    public void load(int taxID, classes.TaxNodesWrapper tnw, Connection con)throws Exception{
        m_TaxID=taxID;
        m_TaxName=tnw.getName(m_TaxID);
        m_RawTexts=new HashMap<String, String>();
        m_Parasites=new SpeciesCollection();
        String sql="SELECT * FROM host WHERE TaxID=" + String.valueOf(m_TaxID);
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(sql);
        while(res.next()){
            String rt=res.getString("RawText");
            String s=m_RawTexts.get(rt);
            if(s==null){ m_RawTexts.put(rt, rt); }
        }
        res.close();
        st.close();
        if(m_RawTexts.isEmpty()){
            m_TaxID=-1;
            return;
        }
        m_Parasites.loadParasitesForHost(m_TaxID, con);
    }
    
    public int getTaxID(){
        return m_TaxID;
    }
    public void setTaxID(int value){
        m_TaxID=value;
    }
    
    public String getTaxName(){
        return m_TaxName;
    }
    
    public HashMap<String,String> getRawTexts(){
        return m_RawTexts;
    }
    
    public String getRawText(int index){
        Object o=m_RawTexts.keySet().toArray()[index];
        String key=(String)o;
        return m_RawTexts.get(key);
    }
    
    public SpeciesCollection getParasites(){
        return m_Parasites;
    }
    
    
    
    
}

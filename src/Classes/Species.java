/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.frmMain;
import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ralfne
 */
public class Species {
    public enum ParasiteType{Unknown, NoParasite, HostAssociated,Symbiant,Parasite}
    private int m_ID=0;
    private Integer m_TaxID=null;
    private String m_Name="";
    private String m_Comment="";
    private Validation m_Validation=null;
    private String m_References="";
    private Date m_CreatedDate=null;
    private GiNumberCollection m_GiNumbers=null;
    private HostCollection m_Hosts=null;
    private ParasiteType m_ParasiteType= ParasiteType.Unknown;    
    private boolean m_Exported=false;
    
    public String getName(){return m_Name;}
    public String getComment(){return m_Comment;}
    public int getID(){return m_ID;}
    public Integer getTaxID(){return m_TaxID;}
    public String getReferences(){return m_References;}
    public Date  getCreatedDate(){return m_CreatedDate;}
    public GiNumberCollection getGiNumbers(){return m_GiNumbers;}
    public Validation getValidation(){return m_Validation;}
    public HostCollection getHosts(){return m_Hosts;}
    public ParasiteType getParasiteType(){return m_ParasiteType;}
    public boolean getExported(){ return m_Exported; }

    public void setName(String value){m_Name=value;}
    public void setComment(String value){m_Comment=value;}
    public void setID(int value){m_ID=value;}
    public void setTaxID(Integer value){m_TaxID=value;}
    public void setReferences(String value){m_References=value;}
    public void setCreatedDate(Date value){m_CreatedDate=value;}
    public void setGiNumbers(GiNumberCollection value){m_GiNumbers=value;}
    public void setValidation(Validation value){m_Validation=value;}
    public void setParasiteType(ParasiteType value){m_ParasiteType=value;}
    public void setExported(boolean value){ m_Exported=value; }

    public Species(){
        m_GiNumbers=new GiNumberCollection(this);
        m_Hosts=new HostCollection(this);
    }
    
    public String toString(){
        return m_Name;
    }
    
    public void save(Connection con)throws Exception{
        if(m_ID>0){
            update(con);
        }else{
            insert(con);
        }
    }
    
    public static int getParasiteTypeAsNumber(ParasiteType pt){
        int out=0;
        if(pt==ParasiteType.Unknown){
            out=0;
        }else if(pt==ParasiteType.NoParasite){
            out=1;
        }else if(pt==ParasiteType.HostAssociated){
            out=2;
        }else if(pt==ParasiteType.Symbiant){
            out=3;
        }else if(pt==ParasiteType.Parasite){
            out=4;
        }
        return out;
    }

    public static String getParasiteTypeAsString(ParasiteType pt){
        String out="";
        if(pt==ParasiteType.Unknown){
            out="Unknown";
        }else if(pt==ParasiteType.NoParasite){
            out="Free living";
        }else if(pt==ParasiteType.HostAssociated){
            out="Host associated";
        }else if(pt==ParasiteType.Symbiant){
            out="Symbiont";
        }else if(pt==ParasiteType.Parasite){
            out="Parasite";
        }
        return out;
    }

    private ParasiteType parseParasiteType(int value){
        ParasiteType pt= ParasiteType.Unknown;
        if(value==0){
            pt= ParasiteType.Unknown;
        }else if(value==1){
            pt= ParasiteType.NoParasite;
        }else if(value==2){
            pt= ParasiteType.HostAssociated;
        }else if(value==3){
            pt= ParasiteType.Symbiant;
        }else if(value==4){
            pt= ParasiteType.Parasite;
        }
        return pt;
    }
    
    private void insert(Connection con) throws Exception{
        m_CreatedDate=new Date();
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        
        if(m_TaxID!=null){
            names.add("TaxID");
            values.add(String.valueOf(m_TaxID));
        }
        names.add("Name");
        values.add("\"" + m_Name + "\"");
        names.add("Comment");
        values.add("\"" + m_Comment + "\"");
        names.add("ParasiteType");
        values.add(String.valueOf(Species.getParasiteTypeAsNumber(m_ParasiteType)));
        
        if(!m_References.equals("")){
            names.add("References");
            values.add("\"" +  m_References + "\"");
        }
        if(m_Validation!=null){
            names.add("ValidationID");
            values.add(String.valueOf(m_Validation.getID()));
        }
        names.add("CreatedDate");
        String s=SpeciesCollection.getDateAsString(m_CreatedDate);
        values.add("\""+s+"\"");
        names.add("IsExported");
        values.add("0");
        String sql=SpeciesCollection.getINSERTsql("species", names, values);
        Statement st=con.createStatement();
        int tmp=st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet res= st.getGeneratedKeys();        
        boolean x=res.first();
        m_ID=res.getInt(1);
        res.close();
        st.close();
    }
    
    private void update(Connection con)throws Exception{
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        names.add("Name");
        values.add("\"" + m_Name + "\"");
        names.add("Comment");
        values.add("\"" + m_Comment + "\"");
        names.add("ParasiteType");
        values.add(String.valueOf(Species.getParasiteTypeAsNumber(m_ParasiteType)));
        names.add("References");
        values.add("\"" + m_References + "\"");
        if(m_TaxID!=null){
            names.add("TaxID");
            values.add(String.valueOf(m_TaxID));
        }
        if(m_Validation!=null){
            names.add("ValidationID");
            values.add(String.valueOf(m_Validation.getID()));
        }

        String sql=SpeciesCollection.getUPDATEsql(m_ID, "species", names, values);
        Statement st=con.createStatement();
        st.execute(sql);
        st.close();
        
    }
    
    public void updateStatus(Connection con, Validation defaultValidation)throws Exception{
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        names.add("ParasiteType");
        if(m_Hosts.isEmpty()){
            values.add(String.valueOf(Species.getParasiteTypeAsNumber(ParasiteType.NoParasite)));
        }else{
            values.add(String.valueOf(Species.getParasiteTypeAsNumber(ParasiteType.Parasite)));    
        }
        names.add("ValidationID");
        values.add(String.valueOf(defaultValidation.getID()));
        String sql=SpeciesCollection.getUPDATEsql(m_ID, "species", names, values);
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    
    public void updateIsExported(boolean isExported, Connection con) throws Exception{
        String sql="UPDATE species SET IsExported=";
        if(isExported){
            sql+="1";
        }else{
            sql+="0";
        }
        sql+=" WHERE ID=" + String.valueOf(m_ID);
        Statement st=con.createStatement();
        st.executeUpdate(sql);
        st.close();
        
    }
    
    public void delete(Connection con) throws Exception{
        deleteGiNumbersAndHosts(con);
        String sql="DELETE FROM species WHERE ID=" + String.valueOf(m_ID);
        Statement st=con.createStatement();
        st.execute(sql);
        st.close();
    }
    
    public void deleteGiNumbersAndHosts(Connection con) throws Exception{
        m_GiNumbers.delete(con);
        m_Hosts.delete(con);
    }
        
    public void loadFromName(String name, Connection con)throws Exception{
        m_Name=name;
        Statement st=con.createStatement();
        String s="SELECT * FROM species WHERE Name='" + m_Name + "'";
        ResultSet res=st.executeQuery(s);
        if (res.first()){
            load(res);
            res.close();
            st.close();            
        }else{
            m_ID=-1;
        }
    }
    public void loadFromTaxID(int taxID, Connection con)throws Exception{
        m_TaxID=taxID;
        Statement st=con.createStatement();
        String s="SELECT * FROM species WHERE TaxID=" + String.valueOf(m_TaxID);
        ResultSet res=st.executeQuery(s);
        if (res.first()){
            load(res);
            res.close();
            st.close();            
        }else{
            m_ID=-1;
        }
    }
    
    public void load(ResultSet res)throws Exception{
        m_Name=res.getString("Name");
        m_Comment=res.getString("Comment");
        m_TaxID=res.getInt("TaxID");
        if (res.wasNull()) m_TaxID=null;
        m_ID=res.getInt("ID");
        m_ParasiteType=parseParasiteType(res.getInt("ParasiteType"));
        m_References=res.getString("References");
        m_CreatedDate=res.getTimestamp("CreatedDate");
        int validationID=res.getInt("ValidationID");
        if(!res.wasNull()){
            m_Validation=frmMain.getfrmMain().getValidations().get(validationID);
        }
    }
    
    public void writeTaxIDAndSpeciesNames(BufferedWriter bw)throws Exception{
        bw.write(String.valueOf(this.m_TaxID));
        bw.write("\t");
        bw.write(this.m_Name);
        bw.newLine();
    }

}

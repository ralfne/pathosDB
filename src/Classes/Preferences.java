/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import GUI.frmMain;
import classes.TaxNodesWrapper.Rank;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Ralf Neumann
 */
public class Preferences implements Serializable{
    private String m_DbUrl = "jdbc:mysql://localhost:3306/";
    private String m_DbName="parasitedb";
    private String m_DbDriver = "com.mysql.jdbc.Driver";
    private String m_DbUserName = "root";
    private String m_DbPassword = "13Pripps";
    private String m_TaxonomyFilename="";
    private Integer m_HostSpeciesInferenceLimit=10000;
    private Rank m_HostTaxInfoRank= Rank.Phylum;
    
    private static final String PREFERENCES_NODE="ParasiteDB";
    private static final String PREFERENCES_KEY="Preferences";

    public String getDbUrl(){return m_DbUrl;}
    public String getDbName(){return m_DbName;}
    public String getDbDriver(){return m_DbDriver;}
    public String getDbUserName(){return m_DbUserName;}
    public String getDbPassword(){return m_DbPassword;}
    public String getTaxonomyFilename(){return m_TaxonomyFilename;}
    public Integer getHostSpeciesInferenceLimit(){return m_HostSpeciesInferenceLimit;}
    public Rank getHostTaxInfoRank(){return m_HostTaxInfoRank;}
    
    public void setDbUrl(String value){m_DbUrl=value;}
    public void setDbName(String value){m_DbName=value;}
    public void setDbDriver(String value){m_DbDriver=value;}
    public void setDbUserName(String value){m_DbUserName=value;}
    public void setDbPassword(String value){m_DbPassword=value;}
    public void setTaxonomyFilename(String value){m_TaxonomyFilename=value;}
    public void setHostSpeciesInferenceLimit(Integer value){m_HostSpeciesInferenceLimit=value;}
    public void setHostTaxInfoRank(Rank r){m_HostTaxInfoRank=r;}

    public void persist()throws Exception{
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userRoot().node(PREFERENCES_NODE);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream objstr= new ObjectOutputStream(bos);
        objstr.writeObject(this);
        objstr.flush();
        objstr.close();
        prefs.putByteArray(PREFERENCES_KEY, bos.toByteArray());
    }
    
    public static Preferences instantiate()throws PreferencesException{
        Preferences prefs=null;
        try{
            java.util.prefs.Preferences javaPrefs = java.util.prefs.Preferences.userRoot().node(PREFERENCES_NODE);
            byte[] b=javaPrefs.getByteArray(PREFERENCES_KEY, null);
            if(b!=null){
                ByteArrayInputStream bis=new ByteArrayInputStream(b);
                ObjectInputStream objstr= new ObjectInputStream(bis);
                prefs=(Preferences)objstr.readObject();
                objstr.close();
            }
        }catch(Exception ex){
            throw new PreferencesException();
        }
        return prefs;
    }

    public static class PreferencesException extends Exception{
        @Override public String getMessage(){
            String m="Preferences could not be loaded." + frmMain.NEWLINE;
            m+="This can be caused by installation of a new version of ParasiteDB." + frmMain.NEWLINE;
            m+="Open 'Preferences', adjust settings if necessary " + frmMain.NEWLINE;
            m+="and click 'Apply' in order to avoid this message." + frmMain.NEWLINE;
            return m;
        }

        @Override
        public String toString(){
            return "Preferences exception";
        }
    }
}

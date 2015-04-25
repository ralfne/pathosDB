/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ralfne
 */
public class Validation {
    private int m_ID=0;
    private String m_Type="";
    private boolean m_Default=false;
    
    public Validation(int id, String type, boolean isDefault){
        m_ID=id;
        m_Type=type;
        m_Default=isDefault;
    }
    
    public String getType(){return m_Type;}
    public int getID(){return m_ID;}
    public boolean getDefault(){return m_Default;}
    
    @Override public String toString(){
        return m_Type;
    }
}

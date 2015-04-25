/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class ValidationCollection extends HashMap<Integer, Validation> {
    private Validation m_Default=null;
    
    public Validation getDefault(){return m_Default;}
    
    public Validation getManual(){
        Iterator<Integer> iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer id=iter.next();
            Validation v=this.get(id);
            if(v.getType().equals("Manual")){
                return v;
            }
        }
        return null;
    }
    
    public void load(Connection conn)throws Exception{
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM  Validation");
        while (res.next()) {
            int id = res.getInt("ID");
            String type = res.getString("Type");
            boolean isDefault=res.getBoolean("Default");
            Validation v=new Validation(id,type, isDefault);
            if(isDefault){
                m_Default=v;
            }
            this.put(id, v);
        }
        res.close();
        st.close();
    }
    
    public Validation getForIndex(int index){
        Object[] keys=this.keySet().toArray();
        int i=(Integer)keys[index];
        return this.get(i);
    }
    
}

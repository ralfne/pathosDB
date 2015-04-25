/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ralfne
 */
public class TextCount implements Comparable<TextCount> {
    private String m_Text="";
    private Integer m_Count=0;
    
    public String getText(){
        return m_Text;
    }
    public void setText(String value){
        m_Text=value;
    }
    public Integer getCount(){
        return m_Count;
    }
    public void setCount(Integer value){
        m_Count=value;
    }
    public void incrementCount(){
        m_Count++;
    }
    public int compareTo(TextCount tc){
        int out=tc.getCount().compareTo(m_Count);
        return out;
    }
    
}

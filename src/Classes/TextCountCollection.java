/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class TextCountCollection extends ArrayList<TextCount> {
 
    public void addText(String text){
        TextCount tc=getByText(text);
        if(tc==null){
            tc=new TextCount();
            tc.setText(text);
            this.add(tc);
        }
        tc.incrementCount();
    }
    
    public TextCount getByText(String text){
        Iterator<TextCount> iter=this.iterator();
        while(iter.hasNext()){
            TextCount textC=iter.next();
            if(textC.getText().equals(text)){
                return textC;
            }
        }
        return null;
    }
    
    public void sort(){
        Collections.sort(this);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class ResolvedHostCollection extends HashMap<Integer, ResolvedHost> {

    public ResolvedHost getByIndex(int i){
        int count=0;
        Iterator<Integer> iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer key=iter.next();
            if(count==i){
                ResolvedHost h=this.get(key);
                return h;
            }
            count++;
        }
        return null;
    }
    
}

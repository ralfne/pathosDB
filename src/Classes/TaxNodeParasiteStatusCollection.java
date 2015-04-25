/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ralfne
 */
public class TaxNodeParasiteStatusCollection extends HashMap<Integer, TaxNodeParasiteStatus> {
    private SpeciesCollection m_Parasites=null;
    private SpeciesCollection m_NonParasites=null;
    private classes.TaxNodesWrapper m_TaxNodes=null;
    public void add(TaxNodeParasiteStatus t){
        this.put(t.TaxID, t);
    }
    public void init(SpeciesCollection parasites,SpeciesCollection nonParasites, classes.TaxNodesWrapper taxnodes){
        m_Parasites=parasites;
        m_NonParasites=nonParasites;
        m_TaxNodes=taxnodes;
        Iterator<Integer> iter=m_Parasites.keySet().iterator();
        while(iter.hasNext()){
            Integer taxID=iter.next();
            Species s=m_Parasites.get(taxID);
            addToStatus(s);
        }
        calculatePercentages();
    }
    private void addToStatus(Species s){
        int parentTaxID=m_TaxNodes.getParentID(s.getTaxID());
        TaxNodeParasiteStatus status=this.get(parentTaxID);
        if(status==null){
            status=new TaxNodeParasiteStatus();
            status.TaxID=parentTaxID;
            status.ParasiteChildren=0;
            this.add(status);
        }
        status.ParasiteChildren++;
    }
    private void calculatePercentages(){
        Iterator<Integer> iter=this.keySet().iterator();
        while(iter.hasNext()){
            Integer taxID=iter.next();
            int count=getChildrenSpeciesForNode(taxID);
            TaxNodeParasiteStatus status=this.get(taxID);
            status.calculatePercentage(count);
        }
    }
    private int getChildrenSpeciesForNode(int taxdID){
        int count=0;
        ArrayList<Integer> ids=m_TaxNodes.getChildren(taxdID);
        Iterator<Integer> iter=ids.iterator();
        while(iter.hasNext()){
            int taxID=iter.next();
            Species s=m_Parasites.get(taxID);
            if(s!=null){
                count++;
            }else{
                s=m_NonParasites.get(taxID);
                if(s!=null){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isExtendedParasite(String taxName, double percentageCutoff){
        Integer taxID=m_TaxNodes.getTaxID(taxName,true);
        if(taxID==null)return false;

        Integer parentTaxID=m_TaxNodes.getParentID(taxID);
        if(parentTaxID==null){
            return false;
        }
        TaxNodeParasiteStatus status=this.get(parentTaxID);
        if(status==null){
            //initialization only creates status objects for existing parasites in db.
            //if status==null there is no parasite in this group
            return false;
        }
        if(status.ParasitePercentage>=percentageCutoff){
            return true;
        }else{
            return false;
        }

    }
    
}

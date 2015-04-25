/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ralfne
 */
public class GiNumberDownloader {
    private String m_BaseURL="http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=nucleotide&term=";

    public static String getTaxIDQueryString(int taxID){
        String s="txid" + String.valueOf(taxID)  + "[Organism]";
        return s;
    }
    
    public ArrayList<String> getGiNumbers(String query, int retmax)throws Exception{
        ArrayList<String> recs=new ArrayList<String>();
        String url=m_BaseURL + query + "&RetMax=" + String.valueOf(retmax);
       
        String ncbiXML=EUtilsTool.getURLContent(url);
        Document ncbiXMLDoc=EUtilsTool.getXMLDocument(ncbiXML);
       
        recs=getGenbankRecordsFromDoc(ncbiXMLDoc);
        
        return recs;
    }
    
    
    public ArrayList<String> getGiNumbers(int taxID, int retmax)throws Exception{
        ArrayList<String> recs=new ArrayList<String>();
        //String url=m_BaseURL + "txid" + String.valueOf(taxID)  + "[Organism]&RetMax=" + String.valueOf(retmax);
        String url=m_BaseURL + getTaxIDQueryString(taxID) + "&RetMax=" + String.valueOf(retmax);
       
        String ncbiXML=EUtilsTool.getURLContent(url);
        Document ncbiXMLDoc=EUtilsTool.getXMLDocument(ncbiXML);
       
        recs=getGenbankRecordsFromDoc(ncbiXMLDoc);
        
        return recs;
    }
   
    private ArrayList<String> getGenbankRecordsFromDoc(Document doc){
        ArrayList<String> recs=new ArrayList<String>();
        NodeList nodes=doc.getElementsByTagName("IdList");
        Node tmp=nodes.item(0);
        nodes.item(0).getChildNodes().getLength();
        for(int i=0;i<tmp.getChildNodes().getLength();i++){
            Node node=tmp.getChildNodes().item(i);
            String s=node.getChildNodes().item(0).getNodeValue();
            recs.add(s);
        }
        return recs;
    }
   
}

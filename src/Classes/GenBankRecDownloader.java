/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author ralfne
 */
public class GenBankRecDownloader {
    private String m_BaseURL="http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=";

    public String getFASTArecord(String giNumber)throws Exception{
        String url=m_BaseURL + giNumber + "&rettype=fasta&retmode=text";
        String fa=EUtilsTool.getURLContent(url, true);
        return fa;
    }
    
    public String getOrganism(String giNumber) throws Exception{
        String url=m_BaseURL + giNumber + "&rettype=gb&retmode=xml";
        String xmlRec=EUtilsTool.getURLContent(url);
        Document ncbiXMLDoc=EUtilsTool.getXMLDocument(xmlRec);
        String org=getOrganismFromXML(ncbiXMLDoc);
        return org; 
    }
    
    private String getOrganismFromXML(Document doc){
        NodeList nodes=doc.getElementsByTagName("GBSeq_organism");
        String orgName=nodes.item(0).getFirstChild().getNodeValue();
        return orgName;
    }
    
    public String getHost(String giNumber) throws Exception{
        String url=m_BaseURL + giNumber + "&rettype=gb&retmode=text";
        String genbankRec=EUtilsTool.getURLContent(url);
        if(!genbankRec.contains("/host"))return "";
        String features=extractFeatures(genbankRec);
        String host=extractHost(features);
        return host;
    }
    
    private String extractFeatures(String rec) throws Exception{
        int featuresI=rec.indexOf("FEATURES");
        if (featuresI==-1) throw new Exception("parse error");
//////        int originI=rec.indexOf("ORIGIN");
//////        if (originI==-1) throw new Exception("parse error");
        String featuresS=rec.substring(featuresI);
        return featuresS;
    }

    private String extractHost(String features)throws Exception{
        int hostI=features.indexOf("/host");
        if (hostI==-1) throw new Exception("parse error");
        String tmp=features.substring(hostI);
        int i=tmp.indexOf("=\"");
        if (i==-1) throw new Exception("parse error");
        tmp=tmp.substring(i+2);
        i=tmp.indexOf("\"");
        if (i==-1) throw new Exception("parse error");
        tmp=tmp.substring(0,i);
        return tmp;   
    }

}

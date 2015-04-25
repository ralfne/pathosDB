/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import java.net.URLConnection;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author ralfne
 */
public class TaxIDDownloader {
    private String m_BaseURL="http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=Taxonomy&term=";
    
    public void appendTaxID(String taxName, ArrayList<String> out) throws Exception{
        int taxID=getTaxID(taxName);
        out.add(String.valueOf(taxID) + "\t" + taxName);
    }
    public int getTaxID(String taxName) throws Exception{
        String webTaxname=taxName.replace(" ", "%20");
        String url=m_BaseURL + webTaxname;
        String ncbiXML=EUtilsTool.getURLContent(url);
        Document ncbiXMLDoc=EUtilsTool.getXMLDocument(ncbiXML);
        int taxID=getTaxID(ncbiXMLDoc);
        return taxID;
    }
    private int getTaxID(Document xmlDoc){
        String val=xmlDoc.getElementsByTagName("Id").item(0).getFirstChild().getNodeValue();
        int taxID=Integer.parseInt(val);
        return taxID;
    }

}

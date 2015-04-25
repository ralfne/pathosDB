/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.frmMain;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author ralfne
 */
public class EUtilsTool {

    public static String getURLContent(String p_sURL) throws Exception{ 
        return getURLContent(p_sURL, false);
    }
    public static String getURLContent(String p_sURL, boolean  includeNewline) throws Exception{ 
        String sLine;
        URL oURL = new URL(p_sURL);
        URLConnection oConnection = oURL.openConnection();
        oConnection.setReadTimeout(60*1000);
        BufferedReader oReader = new BufferedReader(new InputStreamReader(oConnection.getInputStream()));
        StringBuilder sbResponse = new StringBuilder();
        boolean first=true;
        while((sLine = oReader.readLine()) != null)
        {
            if(first){
                first=false;
            }else{
                if(includeNewline)sbResponse.append(frmMain.NEWLINE);
            }
            sbResponse.append(sLine);
        }
        return sbResponse.toString();
    }
   
    public static Document getXMLDocument(String xml)throws Exception{
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
	Document doc = dBuilder.parse(is);
        
        return doc;
    }
 
}

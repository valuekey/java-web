package com.yyq.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class DomWriter {
    public static void main (String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Document doc = null;
        doc = builder.newDocument();
        
        Element phonelist = doc.createElement("phonelist");
        Element linkman = doc.createElement("linkman");
        Element name = doc.createElement("name");
        Element phoneno = doc.createElement("phoneno");
        
        name.appendChild(doc.createTextNode("YYQ"));
        phoneno.appendChild(doc.createTextNode("123321"));
        linkman.appendChild(name);
        linkman.appendChild(phoneno);
        phonelist.appendChild(linkman);
        
        doc.appendChild(phonelist);
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = null;
        
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("WebContent\\table.xml"));
        try {
            t.transform(source, result);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    
}

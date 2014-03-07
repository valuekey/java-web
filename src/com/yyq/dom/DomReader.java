package com.yyq.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse("WebContent\\table.xml");
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        NodeList list = doc.getElementsByTagName("linkman");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element)list.item(i);
            System.out.println(e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            System.out.println(e.getElementsByTagName("phoneno").item(0).getFirstChild().getNodeValue());
//            System.out.println(e.getFirstChild().);
//            System.out.println(list.item(0).getFirstChild().);
        }
    }

}

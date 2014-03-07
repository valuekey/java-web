package com.yyq.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX extends DefaultHandler{
    public static void main (String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MySAX sax = new MySAX();
        try {
            parser.parse(new File("WebContent\\table.xml"), sax);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("<?xml version\"1.0\" endcoding=\"UTF-8\"?>");
    }
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("over");
    }
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.print("<");
        System.out.print(qName);
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
            }
        }
        System.out.println(">");
    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        System.out.print(new String(ch, start, length));
    }
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO Auto-generated method stub
        System.out.print("</");
        System.out.print(qName);
        System.out.println(">");
    }
}

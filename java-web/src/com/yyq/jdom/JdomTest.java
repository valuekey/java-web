package com.yyq.jdom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class JdomTest {
    public static void main (String[] args) {
        Element phonelist = new Element("phonelist");
        Element linkman = new Element("linkman");
        Element linkman1 = new Element("linkman");
        Element name = new Element("name");
        Element phoneno = new Element("phoneno");
        Attribute id = new Attribute("id", "123");
        Document document = new Document(phonelist);
        name.setText("YYQ");
        phoneno.setText("123456");
        name.setAttribute(id);
        linkman.addContent(name);
        linkman.addContent(phoneno);
        phonelist.addContent(linkman);
        phonelist.addContent(linkman1);
//        phonelist.addContent(linkman);
        
        XMLOutputter out = new XMLOutputter();
        out.setFormat(out.getFormat().setEncoding("UTF-8"));
        try {
            out.output(document, new FileOutputStream("WebContent\\table2.xml"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        SAXBuilder builder = new SAXBuilder();
        Document read_doc = null;
        try {
            read_doc = builder.build("WebContent\\table2.xml");
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Element element = read_doc.getRootElement();
        List<Element> list = element.getChildren("linkman");
        for (int i = 0; i < list.size(); i++){
            Element e = list.get(i);
            System.out.println("name:" + e.getChildText("name"));
            System.out.println("phone:" + e.getChildText("phoneno"));
        }
    }
}

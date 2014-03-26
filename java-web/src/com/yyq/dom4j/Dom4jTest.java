package com.yyq.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {
    public static void main (String[] args) {
        Document doc = DocumentHelper.createDocument();
        Element phonelist = doc.addElement("phonelist");
        Element linkman = phonelist.addElement("linkman");
        Element name = linkman.addElement("name");
        Element phoneno = linkman.addElement("phoneno");
        name.setText("YYQ");
        phoneno.setText("333333");
        OutputFormat format = OutputFormat.createCompactFormat();
        format.setEncoding("UTF-8");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(new File("WebContent\\tabledom4j.xml")), format);
            writer.write(doc);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        File file = new File("WebContent\\tabledom4j.xml");
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Iterator iter = root.elementIterator();
        while (iter.hasNext()) {
            Element temp = (Element)iter.next();
            System.out.println(temp.elementText("name"));
            System.out.println(temp.elementText("phoneno"));
        }
    }
}

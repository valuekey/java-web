package com.yyq.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


public class mysql2xml {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://180.178.57.164:3306/a0313135557";
        String user = "a0313135557";
        String password  = "16547228";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("Succeeded!");
                
            }
            stat = conn.createStatement();
            String sql = "SELECT id, NAME, countrycode, district, population FROM city LIMIT 0, 1000";
            rs = stat.executeQuery(sql);
            writeXML(rs);
                
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

    private static void writeXML(ResultSet rs) {
        // TODO Auto-generated method stub
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Document doc = builder.newDocument();
        Element citylist = doc.createElement("citylist");
        Element id = doc.createElement("id");
        Element name = doc.createElement("name");
        Element countrycode = doc.createElement("countrycode");
        Element district = doc.createElement("district");
        Element population = doc.createElement("population");
        
        Element city = doc.createElement("city");
        try {
            while (rs.next()) {

                id = doc.createElement("id");
                name = doc.createElement("name");
                countrycode = doc.createElement("countrycode");
                district = doc.createElement("district");
                population = doc.createElement("population");
                
                city = doc.createElement("city");
                
                id.appendChild(doc.createTextNode(rs.getString(1)));
                name.appendChild(doc.createTextNode(rs.getString(2)));
                countrycode.appendChild(doc.createTextNode(rs.getString(3)));
                district.appendChild(doc.createTextNode(rs.getString(4)));
                population.appendChild(doc.createTextNode(rs.getString(5)));
                
                city.appendChild(id);
                city.appendChild(name);
                city.appendChild(countrycode);
                city.appendChild(district);
                city.appendChild(population);
                
                citylist.appendChild(city);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        doc.appendChild(citylist);
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
        StreamResult result = new StreamResult("WebContent\\mysql2xml.xml");
        try {
            t.transform(source, result);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

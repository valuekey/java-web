package com.yyq.mysql;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.jdbc.Connection;
import com.yyq.common.CommonConsts;

public class xml2mysql {
    public static void main (String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(xml2mysql.class.getResource("") + "emps.xml");
        } catch (SAXException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        
        NodeList list = doc.getElementsByTagName("emp");
        for (int i = 0; i < list.getLength(); i++) {
            Element empElement = (Element) list.item(i);
            Emp emp = new Emp();
            emp.setEmpno(empElement.getElementsByTagName("empno").item(0).getFirstChild().getNodeValue());
            emp.setEmpname(empElement.getElementsByTagName("empname").item(0).getFirstChild().getNodeValue());
            emp.setJob(empElement.getElementsByTagName("job").item(0).getFirstChild().getNodeValue());
            emp.setHiredate(empElement.getElementsByTagName("hiredate").item(0).getFirstChild().getNodeValue());
            emp.setSal(empElement.getElementsByTagName("sal").item(0).getFirstChild().getNodeValue());
            emp.setComm(empElement.getElementsByTagName("comm").item(0).getFirstChild().getNodeValue());
            insertEmps(emp);
        }
    }
    
    public static void insertEmps (Emp emp) {
        String sql = "insert into emp (empno, empname, job, hiredate, sal, comm) values (?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName(CommonConsts.MYSQL_DRIVER);
            conn = (Connection) DriverManager.getConnection(CommonConsts.MYSQL_URL, CommonConsts.MYSQL_USER, CommonConsts.MYSQL_PASSWORD);
            
            ps = (PreparedStatement) conn.prepareStatement(sql);
            
            ps.setString(1, emp.getEmpno());
            ps.setString(2, emp.getEmpname());
            ps.setString(3, emp.getJob());
            ps.setString(4, emp.getHiredate());
            ps.setString(5, emp.getSal());
            ps.setString(6, emp.getComm());
            
            
            ps.execute();
            
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
    }
}

class Emp {
    public String getEmpno() {
        return empno;
    }
    public void setEmpno(String empno) {
        this.empno = empno;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getHiredate() {
        return hiredate;
    }
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    public String getSal() {
        return sal;
    }
    public void setSal(String sal) {
        this.sal = sal;
    }
    public String getComm() {
        return comm;
    }
    public void setComm(String comm) {
        this.comm = comm;
    }
    private String empno = null;
    private String empname = null;
    private String job = null;
    private String hiredate = null;
    private String sal = null;
    private String comm = null;
}

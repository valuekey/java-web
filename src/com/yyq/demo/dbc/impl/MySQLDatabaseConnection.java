package com.yyq.demo.dbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import com.yyq.demo.dbc.DataBaseConntction;

public class MySQLDatabaseConnection implements DataBaseConntction {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    
    private static final String DBURL = "jdbc:mysql://180.178.57.164:3306/a0313135557";
    
    private static final String DBUSER = "a0313135557";
    
    private static final String DBPASSWORD = "16547228";
    
    private Connection conn = null;
    
    public MySQLDatabaseConnection() throws Exception {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public void close() throws Exception {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}

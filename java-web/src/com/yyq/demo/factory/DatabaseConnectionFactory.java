package com.yyq.demo.factory;

import com.yyq.demo.dbc.DataBaseConntction;
import com.yyq.demo.dbc.impl.MySQLDatabaseConnection;

public class DatabaseConnectionFactory {
    public static DataBaseConntction getDataBaseConntction() throws Exception {
        try {
            return new MySQLDatabaseConnection();
        } catch (Exception e) {
            throw e;
        }
    }
}

package com.yyq.manager.factory;

import com.yyq.manager.dbc.DataBaseConntction;
import com.yyq.manager.dbc.impl.MySQLDatabaseConnection;

public class DatabaseConnectionFactory {
    public static DataBaseConntction getDataBaseConntction() throws Exception {
        try {
            return new MySQLDatabaseConnection();
        } catch (Exception e) {
            throw e;
        }
    }
}

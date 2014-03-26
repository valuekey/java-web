package com.yyq.demo.dbc;

import java.sql.Connection;

public interface DataBaseConntction {
    public Connection getConnection() throws Exception;
    public void close() throws Exception;
}

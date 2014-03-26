package com.yyq.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommonDataSource {
    private String DSNAME = "java:comp/env/jdbc/java-web";
    private Context ctx = null;
    private DataSource ds = null;
    public CommonDataSource() {
        try {
            this.ctx = new InitialContext();
            this.ds = (DataSource) this.ctx.lookup(this.DSNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DataSource getDs() {
        return ds;
    }
}

package com.yyq.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyq.common.CommonDataSource;

public class CheckServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        PrintWriter out = resp.getWriter();
        
        try {
            conn = new CommonDataSource().getDs().getConnection();
            String sql = "select userid from user where userid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, req.getParameter("userid"));

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                out.print("true");
            } else {
                out.print("false");
            }
            pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

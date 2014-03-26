package com.yyq.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yyq.demo.dao.IUserDAO;
import com.yyq.demo.vo.User;

public class UserDAOImpl implements IUserDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    
    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
        String sql = "select name from user where userid = ? and password = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, user.getUserid());
        this.pstmt.setString(2, user.getPassword());
        ResultSet rs = this.pstmt.executeQuery();
        
        if (rs.next()) {
            user.setName(rs.getString(1));
            flag = true;
        }
        } catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                this.pstmt.close();
            }
        }
        
        return flag;
    }
}

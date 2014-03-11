package com.yyq.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yyq.demo.dao.IEmpDAO;
import com.yyq.demo.vo.Emp;

public class EmpDAOImpl implements IEmpDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    
    public EmpDAOImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        String sql = "insert into emp (empno, ename, job, hiredate, sal) values (?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, emp.getEmpno());
        this.pstmt.setString(2, emp.getEname());
        this.pstmt.setString(3, emp.getJob());
        this.pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
        this.pstmt.setFloat(5, emp.getSal());
        
        if (this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = new ArrayList<Emp>();
        
        String sql = "select empno, ename, job, hiredate, sal from emp where ename like ? or job like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        
        this.pstmt.setString(1, "%" + keyWord + "%");
        this.pstmt.setString(2, "%" + keyWord + "%");
        
        ResultSet result = this.pstmt.executeQuery();
        Emp emp = null;
        while (result.next()) {
            emp = new Emp();
            emp.setEmpno(result.getInt(1));
            emp.setEname(result.getString(2));
            emp.setJob(result.getString(3));
            emp.setHiredate(result.getDate(4));
            emp.setSal(result.getFloat(5));
            all.add(emp);
        }
        
        this.pstmt.close();
        return all;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        Emp emp = null;
        
        String sql = "select empno, ename, job, hiredate, sal from emp where empno = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, empno);
        
        ResultSet result = this.pstmt.executeQuery();
        while (result.next()) {
            emp = new Emp();
            emp.setEmpno(result.getInt(1));
            emp.setEname(result.getString(2));
            emp.setJob(result.getString(3));
            emp.setHiredate(result.getDate(4));
            emp.setSal(result.getFloat(5));
        }
        this.pstmt.close();
        return emp;
    }

}

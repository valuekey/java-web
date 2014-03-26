package com.yyq.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yyq.manager.dao.IEmpDAO;
import com.yyq.manager.vo.Dept;
import com.yyq.manager.vo.Emp;

public class EmpDAOImpl implements IEmpDAO{

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    
    public EmpDAOImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        String sql = "insert into emp (empno, ename, job, hiredate, sal, comm, mgr, deptno, photo) values (?,?,?,?,?,?,?,?,?)";
        
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, emp.getEmpno());
        this.pstmt.setString(2, emp.getEname());
        this.pstmt.setString(3, emp.getJob());
        this.pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
        this.pstmt.setFloat(5, emp.getSal());
        this.pstmt.setFloat(6, emp.getComm());
        this.pstmt.setInt(7, emp.getMgr());
        this.pstmt.setInt(8, emp.getDept().getDeptno());
        this.pstmt.setString(9, emp.getPhoto());
        
        if (this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public boolean doUpdate(Emp emp) throws Exception {
        boolean flag = false;
        String sql = "update emp set ename = ?, job = ?, hiredate = ?, sal = ?, comm = ?, mgr = ?, deptno = ?, photo = ? where empno = ?";
        
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(9, emp.getEmpno());
        this.pstmt.setString(1, emp.getEname());
        this.pstmt.setString(2, emp.getJob());
        this.pstmt.setDate(3, new java.sql.Date(emp.getHiredate().getTime()));
        this.pstmt.setFloat(4, emp.getSal());
        this.pstmt.setFloat(5, emp.getComm());
        this.pstmt.setInt(6, emp.getMgr());
        this.pstmt.setInt(7, emp.getDept().getDeptno());
        this.pstmt.setString(8, emp.getPhoto());
        
        if (this.pstmt.executeUpdate() > 0) {
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = new ArrayList<Emp>();
        
        String sql = "SELECT T1.empno, T1.ename, T1.job, T1.hiredate, T1.sal, T1.comm, T1.mgr, T1.deptno, T1.photo, T2.dname, T2.loc FROM emp T1 LEFT JOIN dept T2 ON T1.deptno = T2.deptno WHERE T1.ename like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet result = this.pstmt.executeQuery();
        Emp emp = null;
        Dept dept = null;
        while (result.next()) {
            emp = new Emp();
            dept = new Dept();
            emp.setEmpno(result.getInt("empno"));
            emp.setEname(result.getString("ename"));
            emp.setJob(result.getString("job"));
            emp.setHiredate(result.getDate("hiredate"));
            emp.setSal(result.getFloat("sal"));
            emp.setComm(result.getFloat("comm"));
            emp.setMgr(result.getInt("mgr"));
            dept.setDeptno(result.getInt("deptno"));
            dept.setDname(result.getString("dname"));
            dept.setLoc(result.getString("loc"));
            emp.setPhoto(result.getString("photo"));
            emp.setDept(dept);
            all.add(emp);
        }
        
        this.pstmt.close();
        return all;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        Emp emp = null;
        Dept dept = null;
        String sql = "SELECT T1.empno, T1.ename, T1.job, T1.hiredate, T1.sal, T1.comm, T1.mgr, T1.deptno, T1.photo, T2.dname, T2.loc FROM emp T1 LEFT JOIN dept T2 ON T1.deptno = T2.deptno WHERE T1.empno = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, empno);
        ResultSet result = this.pstmt.executeQuery();
        if (result.next()) {
            emp = new Emp();
            dept = new Dept();
            emp.setEmpno(result.getInt("empno"));
            emp.setEname(result.getString("ename"));
            emp.setJob(result.getString("job"));
            emp.setHiredate(result.getDate("hiredate"));
            emp.setSal(result.getFloat("sal"));
            emp.setComm(result.getFloat("comm"));
            emp.setMgr(result.getInt("mgr"));
            dept.setDeptno(result.getInt("deptno"));
            dept.setDname(result.getString("dname"));
            dept.setLoc(result.getString("loc"));
            emp.setPhoto(result.getString("photo"));
            emp.setDept(dept);
        }
        
        this.pstmt.close();
        return emp;
    }

}

package com.yyq.demo.dao;

import java.util.Date;

import com.yyq.demo.factory.DAOFactory;
import com.yyq.demo.vo.Emp;

public class TestDAOInsert {
    public static void main (String[] args) throws Exception {
        Emp emp = null;
        for (int x = 0; x < 5; x++) {
            emp = new Emp();
            emp.setEmpno(1000 + x);
            emp.setEname("严英权" + x);
            emp.setJob("程序员" + x);
            emp.setHiredate(new Date());
            emp.setSal(500.01f * x);
            DAOFactory.getIEmpDAOInstance().doCreate(emp);
        }
    }
}

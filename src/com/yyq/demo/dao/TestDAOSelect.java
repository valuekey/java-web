package com.yyq.demo.dao;

import java.util.Iterator;
import java.util.List;

import com.yyq.demo.factory.DAOFactory;
import com.yyq.demo.vo.Emp;

public class TestDAOSelect {
    public static void main (String[] args) throws Exception {
        List<Emp> all = DAOFactory.getIEmpDAOInstance().findAll("");
        Iterator<Emp> iter = all.iterator();
        while (iter.hasNext()) {
            Emp emp = iter.next();
            System.out.println(emp.getEmpno() + "-----" + emp.getEname());
        }
    }
}

package com.yyq.demo.dao;

import java.util.List;

import com.yyq.demo.vo.Emp;

public interface IEmpDAO {
    public boolean doCreate(Emp emp) throws Exception;
    public List<Emp> findAll(String keyWord) throws Exception;
    public Emp findById(int empno) throws Exception;
}

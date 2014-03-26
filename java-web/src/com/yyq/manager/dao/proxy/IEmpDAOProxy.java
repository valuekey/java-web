package com.yyq.manager.dao.proxy;

import java.util.List;

import com.yyq.manager.dao.IEmpDAO;
import com.yyq.manager.dao.impl.EmpDAOImpl;
import com.yyq.manager.dbc.DataBaseConntction;
import com.yyq.manager.factory.DatabaseConnectionFactory;
import com.yyq.manager.vo.Emp;

public class IEmpDAOProxy implements IEmpDAO{
    private DataBaseConntction dbc = null;
    private IEmpDAO dao = null;

    public IEmpDAOProxy() throws Exception{
        this.dbc = DatabaseConnectionFactory.getDataBaseConntction();
        this.dao = new EmpDAOImpl(this.dbc.getConnection());
    }
    
    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        
        try {
            if (this.dao.findById(emp.getEmpno()) == null) {
                flag = this.dao.doCreate(emp);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        
        return flag;
    }

    @Override
    public boolean doUpdate(Emp emp) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doUpdate(emp);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = null;
        try {
            all = this.dao.findAll(keyWord);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return all;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        Emp emp = null;
        try {
            emp = this.dao.findById(empno);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return emp;
    }

}

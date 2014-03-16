package com.yyq.demo.factory;

import com.yyq.demo.dao.IEmpDAO;
import com.yyq.demo.dao.IUserDAO;
import com.yyq.demo.dao.proxy.IEmpDAOProxy;
import com.yyq.demo.dao.proxy.IUserDAOProxy;

public class DAOFactory {
    public static IEmpDAO getIEmpDAOInstance() throws Exception {
        return new IEmpDAOProxy();
    }
    public static IUserDAO getIUserDAOInstance() throws Exception {
        return new IUserDAOProxy();
    }
}

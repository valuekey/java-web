package com.yyq.demo.factory;

import com.yyq.demo.dao.IEmpDAO;
import com.yyq.demo.dao.proxy.IEmpDAOProxy;

public class DAOFactory {
    public static IEmpDAO getIEmpDAOInstance() throws Exception {
        return new IEmpDAOProxy();
    }
}

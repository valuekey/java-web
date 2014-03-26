package com.yyq.manager.factory;

import com.yyq.manager.dao.IEmpDAO;
import com.yyq.manager.dao.proxy.IEmpDAOProxy;

public class DAOFactory {
    public static IEmpDAO getIEmpDAOIntance() throws Exception {
        return new IEmpDAOProxy();
    }
}

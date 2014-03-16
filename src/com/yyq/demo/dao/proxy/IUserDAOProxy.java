package com.yyq.demo.dao.proxy;

import com.yyq.demo.dao.IUserDAO;
import com.yyq.demo.dao.impl.UserDAOImpl;
import com.yyq.demo.dbc.DataBaseConntction;
import com.yyq.demo.factory.DatabaseConnectionFactory;
import com.yyq.demo.vo.User;

public class IUserDAOProxy implements IUserDAO{
    private DataBaseConntction dbc = null;
    private IUserDAO dao = null;

    
    public IUserDAOProxy() throws Exception {
        this.dbc = DatabaseConnectionFactory.getDataBaseConntction();
        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }
    @Override
    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.findLogin(user);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
        return flag;
    }

}

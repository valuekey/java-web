package com.yyq.demo.dao;

import com.yyq.demo.vo.User;

public interface IUserDAO {
    public boolean findLogin(User user) throws Exception;
}

package com.starrysky.jdbc.user.service;

import com.starrysky.jdbc.user.dao.UserDao;

public class UserService {
    public boolean login(String name,String pwd){
        return new UserDao().findByNameAndPwd(name,pwd);
    }
}

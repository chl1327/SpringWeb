package org.fkit.service.impl;

import org.fkit.domain.User;
import org.fkit.mapper.UserMapper;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 心痕 on 2017-6-29.
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{

    /**
     * 自动注入UserMapper
     * */
    @Autowired
    private UserMapper userMapper;

    /**
     * UserService接口login方法实现
     * @see { UserService }
     * */
    @Transactional(readOnly=true)
    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithLoginnameAndPassword(loginname, password);
    }

    /**
     * UserService接口registe方法实现
     * @see { UserService }
     * */
    @Transactional
    @Override
    public Boolean register(User user ){
        return userMapper.insertUser(user);
    }


    /**
     * 判断用户登录
     * @see { UserService }
     * */
    @Transactional(readOnly = true)
    @Override
    public User isLogin(String id){
        return userMapper.selectUserById(id);
    }

    /**
     * 更新用户信息
     * @see { UserService }
     * */
    @Transactional
    @Override
    public Boolean updateUser(User user){
        return userMapper.modifyUser(user);
    }
 }

package org.fkit.service;

import org.fkit.domain.User;
import java.util.Map;
/**
 * Created by 心痕 on 2017-6-29.
 */
public interface UserService {
    /**
     * 查询登录用户
     * @param String loginname
     * @param String password
     * @return 找到返回User对象，没有找到返回null
     * */
    User login(String loginname,String password);

    /**
     * 插入用户
     * @param User user
     * @return true
     * */
    Boolean register(User user);

    /**
     * 判断用户登录
     * @param String id
     * @return 找到返回User对象，没有找到返回null
     * */
    User isLogin(String id);

    /**
     * 更新用户信息
     * @param User user
     * @return true
     * */
    Boolean updateUser(User user);
}

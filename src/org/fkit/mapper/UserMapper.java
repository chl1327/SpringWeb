package org.fkit.mapper;

import org.apache.ibatis.annotations.*;
import org.fkit.domain.User;

/**
 * Created by 心痕 on 2017-6-29.
 */
public interface UserMapper {

    /**
     * 根据登录名和密码查询用户
     * @param String loginname
     * @param String password
     * @return 找到返回User对象，没有找到返回null
     * */
    @Select("select * from tb_user where loginname=#{loginname} and password=#{password}")
    User findWithLoginnameAndPassword(@Param("loginname") String loginname,
                                      @Param("password") String password);

    /**
    * 插入用户
    * @param User user
    * @return true
    * */
    @Insert("insert into tb_user(id,username,loginname,password,phone,address,filekey) " +
            "values(#{id},#{username},#{loginname},#{password},#{phone},#{address},#{filekey})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Boolean insertUser(User user);

    /**
     * 根据id查询用户
     * @param String id
     * @return 找到返回User对象，没有找到返回null
     * */
    @Select("select * from tb_user where id=#{id}")
    User selectUserById(@Param("id") String id);

    /*
    * 更新用户信息
    * @param User user
    * @return true
    * */
    @Update("update tb_user set username=#{username},loginname=#{loginname},password=#{password}," +
            "phone=#{phone},address=#{address},filekey=#{filekey} where id=#{id}")
    Boolean modifyUser(User user);
  }

package org.fkit.vo;

import org.fkit.domain.User;

/**
 * Created by chl1327 on 2017/7/1.
 */

public class UserVo {
    private String id;			// id
    private String loginname;	// 登录名
    private String password;	// 密码
    private String filekey;
    private String username;	// 用户名
    private String phone;		// 电话
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey;
    }

    public static User toUser(UserVo userVo){
        User user = new User();
        user.setId(userVo.getId());
        user.setUsername(userVo.getUsername());
        user.setLoginname(userVo.getLoginname());
        user.setPassword(userVo.getPassword());
        user.setPhone(userVo.getPhone());
        user.setAddress(userVo.getAddress());
        user.setFilekey(userVo.getFilekey());
        return user;
    }

    public static UserVo fromUser(User user){
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setLoginname(user.getLoginname());
        userVo.setPassword(user.getPassword());
        userVo.setPhone(user.getPhone());
        userVo.setAddress(user.getAddress());
        userVo.setFilekey(user.getFilekey());
        return userVo;
    }


}

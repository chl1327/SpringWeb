package org.fkit.controller;

import org.fkit.domain.User;
import org.fkit.service.UserService;
import org.fkit.util.Util;
import org.fkit.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 心痕 on 2017-6-29.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody UserVo userVo,
                      HttpSession session) throws IOException {
        User user = userService.login(userVo.getLoginname(),userVo.getPassword());
        HashMap map = new HashMap();
        if(user != null){
            session.setAttribute("CASTGC",user.getId());
            map.put("success",Boolean.valueOf(true));
            map.put("data",user);

        }else{
            map.put("error", Boolean.valueOf(false));
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> register(@RequestBody UserVo userVo) throws IOException{
        HashMap map = new HashMap();
        userVo.setId(Util.getUuid());
        User user = UserVo.toUser(userVo);
        Boolean flag = userService.register(user);
        if (flag) {
            map.put("success", Boolean.valueOf(true));
        } else {
            map.put("error", Boolean.valueOf(true));
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserInfo/{userId}",method = RequestMethod.GET)
    public Map<String,Object> getUserInfo(@PathVariable String userId)throws IOException{
        HashMap map = new HashMap();
        User user = userService.isLogin(userId);
        if (user == null){
            map.put("error",Boolean.valueOf(true));
        }else {
            UserVo userVo = UserVo.fromUser(user);
            map.put("data",userVo);
            map.put("success",Boolean.valueOf(true));
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Map<String,Object> updateUser(@RequestBody UserVo userVo) throws IOException{
        HashMap map = new HashMap();
        User user = UserVo.toUser(userVo);
        Boolean flag = userService.updateUser(user);
        if (flag) {
            map.put("success", Boolean.valueOf(true));
        } else {
            map.put("error", Boolean.valueOf(true));
        }
        return map;
    }

}

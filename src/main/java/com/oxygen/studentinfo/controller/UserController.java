package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.User;
import com.oxygen.studentinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Oxygen
 * @data 2019/11/10
 *
 * 用户控制类
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public Object login(@RequestParam(value = "code")String code) {
        return userService.getOpenid(code);
    }

    @GetMapping("/register")
    public Object register(@RequestParam(value = "tid")String tid,
                           @RequestParam(value = "tname")String tname,
                           @RequestParam(value = "openid")String openid) {

        User user = userService.findUserByTid(tid);

        if (user != null) {
            if (user.getTname().equals(tname) && user.getOpenid() == null) {
                user.setOpenid(openid);
                userService.updateUserOpenid(user);
                return "FINISHED";
            } else {
                return "Access Denied";
            }
        } else {
            return "Access Denied";
        }
    }

    @GetMapping("/access")
    public boolean access(@RequestParam(value = "openid")String openid) {
        return userService.findUserByOpenid(openid) != null;
    }

    @GetMapping("/addUser")
    public Object addUser(@RequestParam(value = "tid")String tid,
                          @RequestParam(value = "tname")String tname,
                          @RequestParam(value = "openid")String openid) {
        if(access(openid)){
            User user = new User();
            user.setTid(tid);
            user.setTname(tname);
            if(userService.addUser(user))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }
}
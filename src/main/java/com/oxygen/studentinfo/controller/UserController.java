package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.PasswordChanger;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 后台管理账号控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/changePassword", params = {"uid", "oldPassword", "password"})
    public Response changePassword(PasswordChanger passwordChanger) {
        return userService.changePassword(passwordChanger);
    }
}

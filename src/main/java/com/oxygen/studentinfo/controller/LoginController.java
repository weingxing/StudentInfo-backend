package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.dto.Welcome;
import com.oxygen.studentinfo.entity.Status;
import com.oxygen.studentinfo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;


/**
 * 后台管理登录控制类
 * @author oxygen
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityService securityService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StatusService statusService;

    @GetMapping("/home")
    public String test() {
        logger.info("请求首页");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        logger.info("请求登录页面");
        return "login";
    }

    @PostMapping(value = "/login", params = {"status"})
    @ResponseBody
    public Response loginResult(String status) {
        try {
            if (status.equals("successful")) {
                logger.info("登录成功");
                return new Response(new Date().toString(), 1, "登录成功",
                        securityService.getUserInfo());
            } else {
                logger.info("登陆失败");
                return new Response(new Date().toString(), 0, "登录失败", null);
            }
        } catch (ClassCastException e){
            logger.error("发生错误\n"+ Arrays.toString(e.getStackTrace()));
            return new Response(new Date().toString(), 0, "发生错误", e.toString());
        }
    }

    @GetMapping("/welcome")
    @ResponseBody
    public Response welcome() {

        return new Response(new Date().toString(), 1,
                "", new Welcome(studentService.getCount(), teacherService.getCount(),
                clazzService.getCount(), majorService.getCount(), statusService.getStatusCode()));
    }

    @GetMapping(value = "/updateStatus", params = {"status"})
    @ResponseBody
    public Response update(boolean status) {
        Status record = new Status();
        record.setId(1);
        if(status)
            record.setStatus(1);
        else
            record.setStatus(0);
        System.out.println(record.getStatus());
        return statusService.update(record);
    }
}

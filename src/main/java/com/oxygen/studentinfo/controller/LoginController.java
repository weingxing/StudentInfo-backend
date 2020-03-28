package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.dto.Welcome;
import com.oxygen.studentinfo.entity.Status;
import com.oxygen.studentinfo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 后台管理登录控制类
 * @author oxygen
 */
@Controller
public class LoginController {
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
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login", params = {"status"})
    @ResponseBody
    public Response loginResult(String status) {
        try {
            if (status.equals("successful")) {
                return new Response(new Date().toString(), 1, "登录成功",
                        securityService.getUserInfo());
            } else {
                return new Response(new Date().toString(), 0, "登录失败", null);
            }
        } catch (ClassCastException e){
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

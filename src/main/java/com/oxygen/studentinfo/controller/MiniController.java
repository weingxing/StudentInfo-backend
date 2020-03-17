package com.oxygen.studentinfo.controller;


import cn.miludeer.jsoncode.JsonCode;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.entity.Teacher;
import com.oxygen.studentinfo.service.ClazzService;
import com.oxygen.studentinfo.service.StudentService;
import com.oxygen.studentinfo.service.TeacherService;
import com.oxygen.studentinfo.util.PageParam;
import com.oxygen.studentinfo.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * 微信小程序接口控控制类
 * @author oxygen
 */
@RestController
@RequestMapping("/mini")
public class MiniController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;

    @GetMapping(value = "/login", params = {"code"})
    public Response login(String code) {
        String response = WechatUtil.getOpenid(code);
        String openid =  JsonCode.getValue(response, "$.openid");
        return new Response(new Date().toString(), 1, "", openid);
    }

    @GetMapping(value = "/access", params = {"openid"})
    public Response access(String openid) {
        if (teacherService.selectByOpenid(openid) != null)
            return new Response(new Date().toString(), 1, "", true);
        return new Response(new Date().toString(), 0, "", false);
    }

    @GetMapping(value = "/register", params = {"tno", "name", "openid"})
    public Response register(Teacher teacher) {
        Teacher t = teacherService.selectByTno(teacher.getTno());

        if (t != null) {
            if (t.getName().equals(teacher.getName()) && t.getOpenid() == null) {
                teacherService.update(teacher);
                return new Response(new Date().toString(), 1, "绑定成功", true);
            }
        }
        return new Response(new Date().toString(), 0, "绑定失败", false);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword", "openid"})
    public Object search(int page, int limit, String keyword, String openid){
        if (!(boolean)access(openid).getContent())
            return new Response(new Date().toString(), 0, "没有权限", null);
        return studentService.search(keyword, new PageParam(page, limit));
    }

    @GetMapping("/getGrade")
    public Response getGrade() {
        return clazzService.getGrade();
    }

    @GetMapping(value = "/getInfoByGrade", params = {"page", "limit", "grade", "openid"})
    public Object getInfoByGrade(int page, int limit, String grade, String openid) {
        if (!(boolean)access(openid).getContent())
            return new Response(new Date().toString(), 0, "没有权限", null);
        return studentService.selectByGrade(grade, new PageParam(page, limit));
    }

    @PostMapping(value = "/updateRemark", params = {"sno", "remark", "openid"})
    public Response updateRemark(String sno, String remark, String openid){
        if (!(boolean)access(openid).getContent())
            return new Response(new Date().toString(), 0, "没有权限", null);
        Student student = new Student();
        student.setSno(sno);
        student.setRemark(remark);
        return studentService.update(student);
    }

    @GetMapping(value = "/getMyClassInfo", params = {"page", "limit", "openid"})
    public Object getMyClassInfo(int page, int limit, String openid) {
        if (!(boolean)access(openid).getContent())
            return new Response(new Date().toString(), 0, "没有权限", null);

        Teacher teacher = teacherService.selectByOpenid(openid);
        if (teacher != null) {
            Integer clazz = teacher.getClazzId();
            if (clazz != null) {
                return studentService.selectByClazz(clazz, new PageParam(page, limit));
            }
        }
        return new Response(new Date().toString(), 0, "不存在信息", null);
    }
}

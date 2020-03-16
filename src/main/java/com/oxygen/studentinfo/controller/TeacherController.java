package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Teacher;
import com.oxygen.studentinfo.service.TeacherService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 教师（小程序用户）控制类
 * @author oxygen
 */
@RestController
@RequestMapping("/page/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        PageParam param = new PageParam(page, limit);
        return teacherService.selectAll(param);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return teacherService.search(keyword, new PageParam(page, limit));
    }

    @DeleteMapping(value = "/delete", params = {"tno"})
    public Response delete(String tno) {
        return teacherService.delete(tno);
    }

    @PostMapping(value = "/add", params = {"tno", "name", "clazzId"})
    public Response add(Teacher teacher) {
        return teacherService.add(teacher);
    }

    @PutMapping(value = "/update", params = {"tno", "name", "openid", "clazzId"})
    public Response update(Teacher teacher) {
        return teacherService.update(teacher);
    }
}

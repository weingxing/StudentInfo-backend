package com.oxygen.studentinfo.controller;


import com.oxygen.studentinfo.config.CommonConfig;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.service.StudentService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) throws Exception {
        PageParam param = new PageParam(page, limit);
        return studentService.selectAll(param);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) throws Exception {
        return studentService.search(keyword, new PageParam(page, limit));
    }

    @DeleteMapping(value = "/delete", params = {"sno"})
    public Response delete(String sno) throws Exception {
        return studentService.delete(sno);
    }

    @PostMapping(value = "/add", params = {"sno", "name", "sex", "category",
            "descCategory", "clazz", "department", "major", "college", "phone",
            "idcard", "address", "remark"})
    public Response add(Student student) throws Exception {
        student.setPhoto(CommonConfig.domain + student.getSno() + ".jpg");
        return studentService.add(student);
    }

    @PutMapping(value = "/update", params = {"sno", "name", "sex", "category",
            "descCategory", "clazz", "department", "major", "college", "phone",
            "idcard", "address", "remark"})
    public Response update(Student student) throws Exception {
        return studentService.update(student);
    }

}

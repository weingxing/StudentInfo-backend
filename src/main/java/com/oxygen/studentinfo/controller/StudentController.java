package com.oxygen.studentinfo.controller;


import com.oxygen.studentinfo.config.PhotoAddress;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.entity.Teacher;
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
    public Page getAll(int page, int limit) {
        PageParam param = new PageParam(page, limit);
        return studentService.selectAll(param);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return studentService.search(keyword, new PageParam(page, limit));
    }

    @DeleteMapping(value = "/delete", params = {"sno"})
    public Response delete(String sno) {
        return studentService.delete(sno);
    }

    @PostMapping(value = "/add", params = {"sno", "name", "sex", "category",
            "descCategory", "clazz", "department", "major", "college", "phone",
            "idcard", "address", "remark"})
    public Response add(Student student) {
        student.setPhoto(PhotoAddress.domain + student.getSno() + ".jpg");
        return studentService.add(student);
    }

    @PutMapping(value = "/update", params = {"sno", "name", "sex", "category",
            "descCategory", "clazz", "department", "major", "college", "phone",
            "idcard", "address", "remark"})
    public Response update(Student student) {
        return studentService.update(student);
    }

}

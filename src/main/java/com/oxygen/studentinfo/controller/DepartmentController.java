package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Department;
import com.oxygen.studentinfo.service.DepartmentService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        return departmentService.selectAll(new PageParam(page, limit));
    }

    @PostMapping(value = "/add", params = {"name"})
    public Response add(Department department) {
        return departmentService.add(department);
    }

    @DeleteMapping(value = "/delete", params = {"id"})
    public Response delete(int id) {
        return departmentService.delete(id);
    }

    @PutMapping(value = "/update", params = {"id", "name"})
    public Response update(Department department) {
        return departmentService.update(department);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return departmentService.search(keyword, new PageParam(page, limit));
    }
}

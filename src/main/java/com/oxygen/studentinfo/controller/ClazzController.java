package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Clazz;
import com.oxygen.studentinfo.service.ClazzService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        PageParam param = new PageParam(page, limit);
        return clazzService.selectAll(param);
    }

    @PostMapping(value = "/add", params = {"name", "grade"})
    public Response add(Clazz clazz) {
        return clazzService.add(clazz);
    }

    @DeleteMapping(value = "/delete", params = {"id"})
    public Response delete(int id) {
        return clazzService.delete(id);
    }

    @PutMapping(value = "/update", params = {"id", "name", "grade"})
    public Response update(Clazz clazz) {
        return clazzService.update(clazz);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return clazzService.search(keyword, new PageParam(page, limit));
    }

    @GetMapping("/getGrade")
    public Response getGrade() {
        return clazzService.getGrade();
    }
}

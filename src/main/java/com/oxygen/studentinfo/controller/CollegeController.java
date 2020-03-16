package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.service.CollegeService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        return collegeService.selectAll(new PageParam(page, limit));
    }

    @PostMapping(value = "/add", params = {"name"})
    public Response add(College college) {
        return collegeService.add(college);
    }

    @DeleteMapping(value = "/delete", params = {"id"})
    public Response delete(int id) {
        return collegeService.delete(id);
    }

    @PutMapping(value = "/update", params = {"id", "name"})
    public Response update(College college) {
        return collegeService.update(college);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return collegeService.search(keyword, new PageParam(page, limit));
    }
}

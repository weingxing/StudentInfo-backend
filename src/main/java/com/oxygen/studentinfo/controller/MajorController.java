package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.service.MajorService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        return majorService.selectAll(new PageParam(page, limit));
    }

    @PostMapping(value = "/add", params = {"name"})
    public Response add(Major major) {
        return majorService.add(major);
    }

    @DeleteMapping(value = "/delete", params = {"id"})
    public Response delete(int id) {
        return majorService.delete(id);
    }

    @PutMapping(value = "/update", params = {"id", "name"})
    public Response update(Major major) {
        return majorService.update(major);
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return majorService.search(keyword, new PageParam(page, limit));
    }
}

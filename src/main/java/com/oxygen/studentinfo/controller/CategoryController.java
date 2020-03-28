package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.service.CategoryService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类别控制类
 * @author oxygen
 * @since 2020/02/21
 */
@RestController
@RequestMapping("/page/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 取得所有的分类信息（分页）
     * @param page
     * @param limit
     * @return Page
     */
    @GetMapping(value = "/getAll", params = {"page", "limit"})
    public Page getAll(int page, int limit) {
        return categoryService.selectAll(new PageParam(page, limit));
    }

    /**
     * 添加分类
     * @param category
     * @return Response
     */
    @PostMapping(value = "/add", params = {"name"})
    public Response add(Category category) {
        return categoryService.add(category);
    }


    /**
     * 删除分类
     * @param id
     * @return Response
     */
    @DeleteMapping(value = "/delete", params = {"id"})
    public Response delete(int id) {
        return categoryService.delete(id);
    }

    /**
     * 更新分类信息
     * @param category
     * @return
     */
    @PutMapping(value = "/update", params = {"id", "name"})
    public Response update(Category category) {
        return categoryService.update(category);
    }

    /**
     * 搜索分类信息（分页）
     * @param page
     * @param limit
     * @param keyword
     * @return Page
     */
    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public Page search(int page, int limit, String keyword) {
        return categoryService.search(keyword, new PageParam(page, limit));
    }
}

package com.oxygen.studentinfo;

import com.oxygen.studentinfo.dao.CategoryMapper;
import com.oxygen.studentinfo.service.CategoryService;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.ls.LSOutput;

public class category {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private static CategoryMapper mapper;

    public static void main(String[] args) {
        System.out.println(mapper.search("%1%"));
    }
}

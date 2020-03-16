package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.util.PageParam;

import java.util.List;

public interface CategoryService {
    public Response add(Category category);

    public Response delete(int id);

    public Response update(Category category);

    public Page selectAll(PageParam param);

    public Page search(String keyword, PageParam param);

    public Category selectByName(String name);
}

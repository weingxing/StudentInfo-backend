package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.CategoryMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.service.CategoryService;
import com.oxygen.studentinfo.util.PageParam;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 类别服务类
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Response add(Category category) {
        if (categoryMapper.insert(category) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 1, "添加失败", null);
    }

    @Override
    public Response delete(int id) {
        if (categoryMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(Category category) {
        if (categoryMapper.updateByPrimaryKeySelective(category) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param) {
        List<Category> data = categoryMapper.selectAllByPage(param.getData());
        int count = categoryMapper.selectAll().size();

        Page page = new Page(0, "", count, data);

        return page;
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%" + keyword + "%");
        List<Category> data = categoryMapper.searchByPage(param.getData());
        int count = categoryMapper.search("%" + keyword + "%").size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Category selectByName(String name) {
        return categoryMapper.selectByName(name);
    }
}

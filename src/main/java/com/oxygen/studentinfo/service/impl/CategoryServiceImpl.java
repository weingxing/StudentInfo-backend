package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.CategoryMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.service.CategoryService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 类别服务接口实现类
 * @author oxygen
 * @since 2020/01/28
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Response add(Category category)  throws Exception {
        // 插入成功或失败分别返回对应的内容
        if (categoryMapper.insert(category) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 1, "添加失败", null);
    }

    @Override
    public Response delete(int id)  throws Exception {
        if (categoryMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(Category category)  throws Exception {
        if (categoryMapper.updateByPrimaryKeySelective(category) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param)  throws Exception {
        // 查询数据并统计数量
        List<Category> data = categoryMapper.selectAllByPage(param.getData());
        int count = categoryMapper.selectAll().size();
        // 封装数据，然后返回
        Page page = new Page(0, "", count, data);

        return page;
    }

    @Override
    public Page search(String keyword, PageParam param)  throws Exception {
        // 对关键词添加通配符，实现模糊搜索
        param.put("keyword", "%" + keyword + "%");
        List<Category> data = categoryMapper.searchByPage(param.getData());
        int count = categoryMapper.search("%" + keyword + "%").size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Category selectByName(String name)  throws Exception {
        return categoryMapper.selectByName(name);
    }
}

package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.ClazzMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Clazz;
import com.oxygen.studentinfo.service.ClazzService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public Response add(Clazz record) {
        if (clazzMapper.insert(record) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 1, "添加失败", null);
    }

    @Override
    public Response delete(int id) {
        if (clazzMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(Clazz record) {
        if (clazzMapper.updateByPrimaryKeySelective(record) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param) {
        List<Clazz> data = clazzMapper.selectAllByPage(param.getData());
        int count = clazzMapper.selectAll().size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%" + keyword + "%");
        int count = clazzMapper.search("%" + keyword + "%").size();
        List<Clazz> data = clazzMapper.searchByPage(param.getData());

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public int getCount() {
        return clazzMapper.selectAll().size();
    }

    @Override
    public Clazz selectByName(String name) {
        return clazzMapper.selectByName(name);
    }

    @Override
    public Response getGrade() {
        List<Clazz> data = clazzMapper.getGrade();
        List<String> grade = new ArrayList<>();
        for (Clazz c : data) {
            grade.add(c.getGrade());
        }
        return new Response(new Date().toString(), 1, "", grade);
    }
}

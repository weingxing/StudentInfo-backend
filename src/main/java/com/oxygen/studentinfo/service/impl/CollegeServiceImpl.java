package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.CollegeMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.service.CollegeService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 学院服务接口实现类
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public Response add(College record) {
        if (collegeMapper.insert(record) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 0, "添加失败", null);
    }

    @Override
    public Response delete(int id) {
        if (collegeMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(College record) {
        if (collegeMapper.updateByPrimaryKeySelective(record) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param) {
        List<College> data = collegeMapper.selectAllByPage(param.getData());
        int count = collegeMapper.selectAll().size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%" + keyword + "%");
        int count = collegeMapper.search("%" + keyword + "%").size();
        List<College> data = collegeMapper.searchByPage(param.getData());

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public College selectByName(String name) {
        return collegeMapper.selectByName(name);
    }
}

package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.DepartmentMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Department;
import com.oxygen.studentinfo.service.DepartmentService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 系别服务接口实现类
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Response add(Department record) {
        if (departmentMapper.insert(record) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 1, "添加失败", null);
    }

    @Override
    public Response delete(int id) {
        if (departmentMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(Department record) {
        if (departmentMapper.updateByPrimaryKeySelective(record) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param) {
        List<Department> data = departmentMapper.selectAllByPage(param.getData());
        int count = departmentMapper.selectAll().size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%" + keyword + "%");
        int count = departmentMapper.search("%" + keyword + "%").size();
        List<Department> data = departmentMapper.searchByPage(param.getData());

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Department selectByName(String name) {
        return departmentMapper.selectByName(name);
    }
}

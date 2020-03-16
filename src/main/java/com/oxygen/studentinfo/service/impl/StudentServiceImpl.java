package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.StudentMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.dto.StudentInfo;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.service.StudentService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page selectAll(PageParam param) {
        List<StudentInfo> data = studentMapper.selectAllByPage(param.getData());
        int count = studentMapper.selectAll().size();
        Page page = new Page();
        page.setCode(0);
        page.setCount(count);
        page.setData(data);
        return page;
    }

    @Override
    public Response add(Student record) {
        if (studentMapper.insert(record) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 0, "添加失败", null);
    }

    @Override
    public Response delete(String tno) {
        if (studentMapper.deleteByPrimaryKey(tno) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 0, "删除失败", null);
    }

    @Override
    public Response update(Student record) {
        if (studentMapper.updateByPrimaryKeySelective(record) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 0, "更新失败", null);
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%"+keyword+"%");

        List<StudentInfo> data = studentMapper.searchByPage(param.getData());
        int count = studentMapper.search("%"+keyword+"%").size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public int getCount() {
        return studentMapper.selectAll().size();
    }

    @Override
    public Page selectByGrade(String grade, PageParam param) {
        param.put("grade", grade);
        List<StudentInfo> data = studentMapper.selectByGrade(param.getData());
        int count = studentMapper.selectAllByGrade(grade).size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Page selectByClazz(Integer clazz, PageParam param) {
        param.put("clazz", clazz);
        List<StudentInfo> data = studentMapper.selectByClazz(param.getData());
        int count = studentMapper.selectAllByClazz(clazz).size();

        Page page = new Page(0, "", count, data);
        return page;
    }
}

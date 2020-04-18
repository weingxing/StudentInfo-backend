package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.TeacherMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.dto.TeacherInfo;
import com.oxygen.studentinfo.entity.Teacher;
import com.oxygen.studentinfo.service.TeacherService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * 教师服务接口实现类
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page selectAll(PageParam param) {
        List<TeacherInfo> data = teacherMapper.selectAllByPage(param.getData());
        int count = teacherMapper.selectAll().size();
        Page page = new Page();
        page.setCode(0);
        page.setCount(count);
        page.setData(data);
        return page;
    }

    @Override
    public Response add(Teacher teacher) {
        if (teacherMapper.insert(teacher) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 0, "添加失败", null);
    }

    @Override
    public Response delete(String tno) {
        if (teacherMapper.deleteByPrimaryKey(tno) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 0, "添加失败", null);
    }

    @Override
    public Response update(Teacher teacher) {
        // 如果在后台点击了 清除openid，会接收到一个空字符串，将openid设为null
        if ("".equals(teacher.getOpenid()))
            teacher.setOpenid(null);

        if (teacherMapper.updateByPrimaryKeySelective(teacher) > 0)
            return new Response(new Date().toString(), 1, "修改成功", null);
        return new Response(new Date().toString(), 0, "修改失败", null);
    }

    @Override
    public Page search(String keyword, PageParam param) {
        param.put("keyword", "%"+keyword+"%");

        List<TeacherInfo> data = teacherMapper.searchByPage(param.getData());
        int count = teacherMapper.search("%"+keyword+"%").size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public int getCount() {
        return teacherMapper.selectAll().size();
    }

    @Override
    public Teacher selectByOpenid(String openid) {
        return teacherMapper.selectByOpenid(openid);
    }

    @Override
    public Teacher selectByTno(String tno) {
        return teacherMapper.selectByPrimaryKey(tno);
    }
}

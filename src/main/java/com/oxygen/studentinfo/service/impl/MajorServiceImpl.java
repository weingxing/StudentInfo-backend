package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.MajorMapper;
import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.service.MajorService;
import com.oxygen.studentinfo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 专业服务接口实现类
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Response add(Major record) throws Exception {
        if (majorMapper.insert(record) > 0)
            return new Response(new Date().toString(), 1, "添加成功", null);
        return new Response(new Date().toString(), 0, "添加失败", null);
    }

    @Override
    public Response delete(int id) throws Exception {
        if (majorMapper.deleteByPrimaryKey(id) > 0)
            return new Response(new Date().toString(), 1, "删除成功", null);
        return new Response(new Date().toString(), 1, "删除失败", null);
    }

    @Override
    public Response update(Major record) throws Exception {
        if (majorMapper.updateByPrimaryKeySelective(record) > 0)
            return new Response(new Date().toString(), 1, "更新成功", null);
        return new Response(new Date().toString(), 1, "更新失败", null);
    }

    @Override
    public Page selectAll(PageParam param) throws Exception {
        List<Major> data = majorMapper.selectAllByPage(param.getData());
        int count = majorMapper.selectAll().size();

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public Page search(String keyword, PageParam param) throws Exception {
        param.put("keyword", "%" + keyword + "%");
        int count = majorMapper.search("%" + keyword + "%").size();
        List<Major> data = majorMapper.searchByPage(param.getData());

        Page page = new Page(0, "", count, data);
        return page;
    }

    @Override
    public int getCount() throws Exception {
        return majorMapper.selectAll().size();
    }

    @Override
    public Major selectByName(String name) throws Exception {
        return majorMapper.selectByName(name);
    }
}

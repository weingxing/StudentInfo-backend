package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.StatusMapper;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Status;
import com.oxygen.studentinfo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusMapper statusMapper;

    @Override
    public Response update(Status record) {
        if(statusMapper.updateByPrimaryKey(record) > 0)
            return new Response(new Date().toString(), 1, "修改成功", null);
        return new Response(new Date().toString(), 1, "修改失败", null);
    }

    @Override
    public Response getStatus() {
        Status status = statusMapper.selectByPrimaryKey(1);
        return new Response(new Date().toString(), 1, "", status.getStatus());
    }

    @Override
    public int getStatusCode() {
        return statusMapper.selectByPrimaryKey(1).getStatus();
    }
}

package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Teacher;
import com.oxygen.studentinfo.util.PageParam;


public interface TeacherService {

    public Page selectAll(PageParam param);

    public Response add(Teacher teacher);

    public Response delete(String tno);

    public Response update(Teacher teacher);

    public Page search(String keyword, PageParam param);

    public int getCount();

    public Teacher selectByOpenid(String openid);

    public Teacher selectByTno(String tno);
}

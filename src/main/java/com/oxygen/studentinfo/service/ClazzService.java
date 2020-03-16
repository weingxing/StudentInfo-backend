package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Clazz;
import com.oxygen.studentinfo.util.PageParam;

public interface ClazzService {
    public Response add(Clazz record);

    public Response delete(int id);

    public Response update(Clazz record);

    public Page selectAll(PageParam param);

    public Page search(String keyword, PageParam param);

    public int getCount();

    public Response getGrade();

    public  Clazz selectByName(String name);
}

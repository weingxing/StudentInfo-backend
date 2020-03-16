package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.util.PageParam;

public interface CollegeService {
    public Response add(College record);

    public Response delete(int id);

    public Response update(College record);

    public Page selectAll(PageParam param);

    public Page search(String keyword, PageParam param);

    public College selectByName(String name);
}

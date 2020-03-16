package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.util.PageParam;

public interface MajorService {
    public Response add(Major record);

    public Response delete(int id);

    public Response update(Major record);

    public Page selectAll(PageParam param);

    public Page search(String keyword, PageParam param);

    public int getCount();

    public Major selectByName(String name);
}

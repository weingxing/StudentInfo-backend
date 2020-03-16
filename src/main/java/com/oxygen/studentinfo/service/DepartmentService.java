package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Department;
import com.oxygen.studentinfo.util.PageParam;

public interface DepartmentService {
    public Response add(Department record);

    public Response delete(int id);

    public Response update(Department record);

    public Page selectAll(PageParam param);

    public Page search(String keyword, PageParam param);

    public Department selectByName(String name);
}

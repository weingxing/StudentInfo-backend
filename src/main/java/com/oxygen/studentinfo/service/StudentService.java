package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.util.PageParam;

public interface StudentService {
    public Page selectAll(PageParam param);

    public Response add(Student record);

    public Response delete(String tno);

    public Response update(Student record);

    public Page search(String keyword, PageParam param);

    public int getCount();

    public Page selectByGrade(String grade, PageParam param);

    public Page selectByClazz(Integer clazz, PageParam param);
}

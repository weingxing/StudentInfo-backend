package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Department;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 系别服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface DepartmentService {
    /**
     * 添加系别
     * @param record
     * @return
     */
    public Response add(Department record);

    /**
     * 删除系别（根据id）
     * @param id
     * @return
     */
    public Response delete(int id);

    /**
     * 更新类别（根据id）
     * @param record
     * @return
     */
    public Response update(Department record);

    /**
     * 查询所有类别，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param);

    /**
     * 根据关键词搜索系别，分页返回数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param);

    /**
     * 根据名称选择系别
     * @param name
     * @return
     */
    public Department selectByName(String name);
}

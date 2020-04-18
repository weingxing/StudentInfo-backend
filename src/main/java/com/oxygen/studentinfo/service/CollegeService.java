package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 学院服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface CollegeService {
    /**
     * 添加学院
     * @param record
     * @return
     */
    public Response add(College record);

    /**
     * 删除学院（按id）
     * @param id
     * @return
     */
    public Response delete(int id);

    /**
     * 更新学院信息（根据id）
     * @param record
     * @return
     */
    public Response update(College record);

    /**
     * 查询所有班级，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param);

    /**
     * 搜索班级，分页返回数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param);

    /**
     * 根据班级名称查询班级
     * @param name
     * @return
     */
    public College selectByName(String name);
}

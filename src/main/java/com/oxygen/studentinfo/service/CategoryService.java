package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.util.PageParam;

import java.util.List;

/**
 * 类别服务接口
 * @author oxygen
 * @since 2020/1/25
 */
public interface CategoryService {
    /**
     * 添加类别
     * @param category
     * @return
     */
    public Response add(Category category);

    /**
     * 删除类别（根据id）
     * @param id
     * @return
     */
    public Response delete(int id);

    /**
     * 更新类别信息（根据id更新）
     * @param category
     * @return
     */
    public Response update(Category category);

    /**
     * 查询全部类别，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param);

    /**
     * 根据关键词搜索类别，分页返回数据，支持模糊搜索
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param);

    /**
     * 根据类别名字查询类别
     * @param name
     * @return
     */
    public Category selectByName(String name);
}

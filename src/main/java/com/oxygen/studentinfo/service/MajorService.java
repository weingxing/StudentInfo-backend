package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 专业服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface MajorService {
    /**
     * 添加专业
     * @param record
     * @return
     */
    public Response add(Major record) throws Exception;

    /**
     * 删除专业（根据id）
     * @param id
     * @return
     */
    public Response delete(int id) throws Exception;

    /**
     * 更新专业信息(根据id）
     * @param record
     * @return
     */
    public Response update(Major record) throws Exception;

    /**
     * 查询所有专业，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param) throws Exception;

    /**
     * 根据关键词查询专业，分页返回数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param) throws Exception;

    /**
     * 取得当前数据中专业的总数
     * @return
     */
    public int getCount() throws Exception;

    /**
     * 根据专业名称查询专业信息
     * @param name
     * @return
     */
    public Major selectByName(String name) throws Exception;
}

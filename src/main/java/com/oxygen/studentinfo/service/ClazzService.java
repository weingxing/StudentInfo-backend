package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Clazz;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 班级服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface ClazzService {
    /**
     * 添加班级
     * @param record
     * @return
     */
    public Response add(Clazz record);

    /**
     * 删除班级（根据id）
     * @param id
     * @return
     */
    public Response delete(int id);

    /**
     * 更新班级信息（根据id）
     * @param record
     * @return
     */
    public Response update(Clazz record);

    /**
     * 查询所有班级，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param);

    /**
     * 根据关键词搜索班级，分页返回输数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param);

    /**
     * 取得班级数量
     * @return
     */
    public int getCount();

    /**
     * 取得所有年级，理论上不会超过四个（大一 ~ 大四），所以没有进行分页
     * @return
     */
    public Response getGrade();

    /**
     * 根据名称选择班级
     * @param name
     * @return
     */
    public  Clazz selectByName(String name);
}

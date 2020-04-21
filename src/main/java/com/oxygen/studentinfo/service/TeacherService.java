package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Teacher;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 教师服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface TeacherService {

    /**
     * 查询所有教师，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param) throws Exception;

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    public Response add(Teacher teacher) throws Exception;

    /**
     * 删除教师（根据工号）
     * @param tno
     * @return
     */
    public Response delete(String tno) throws Exception;

    /**
     * 更新教师信息（根据工号）
     * @param teacher
     * @return
     */
    public Response update(Teacher teacher) throws Exception;

    /**
     * 根据关键词搜索教师，分页返回数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param) throws Exception;

    /**
     * 取得教师总量
     * @return
     */
    public int getCount() throws Exception;

    /**
     * 根据openid查询教师
     * @param openid
     * @return
     */
    public Teacher selectByOpenid(String openid) throws Exception;

    /**
     * 根据工号查询教师
     * @param tno
     * @return
     */
    public Teacher selectByTno(String tno) throws Exception;
}

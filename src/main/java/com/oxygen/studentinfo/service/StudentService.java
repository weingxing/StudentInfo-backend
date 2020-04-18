package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Page;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Student;
import com.oxygen.studentinfo.util.PageParam;

/**
 * 学生服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface StudentService {
    /**
     * 查询所有学生信息，分页返回数据
     * @param param
     * @return
     */
    public Page selectAll(PageParam param);

    /**
     * 添加学生信息
     * @param record
     * @return
     */
    public Response add(Student record);

    /**
     * 删除学生信息（根据学号）
     * @param tno
     * @return
     */
    public Response delete(String tno);

    /**
     * 更新学生信息（根据学号）
     * @param record
     * @return
     */
    public Response update(Student record);

    /**
     * 根据关键词搜索学生信息，分页返回数据
     * @param keyword
     * @param param
     * @return
     */
    public Page search(String keyword, PageParam param);

    /**
     * 取得学生数量
     * @return
     */
    public int getCount();

    /**
     * 根据年级查询学生信息，分页返回数据
     * @param grade
     * @param param
     * @return
     */
    public Page selectByGrade(String grade, PageParam param);

    /**
     * 根据班级查询学生信息，分页返回数据
     * @param clazz
     * @param param
     * @return
     */
    public Page selectByClazz(Integer clazz, PageParam param);
}

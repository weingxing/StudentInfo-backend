package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.dto.TeacherInfo;
import com.oxygen.studentinfo.entity.Teacher;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tno);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tno);

    List<TeacherInfo> selectAll();

    List<TeacherInfo> selectAllByPage(Map<String, Object> param);

    List<TeacherInfo> search(String keyword);

    List<TeacherInfo> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher selectByOpenid(String openid);
}
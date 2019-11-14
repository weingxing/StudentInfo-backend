package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.ClassRoom;

import java.util.List;

public interface ClassRoomMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    ClassRoom selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);

    int deleteByGrade(String grade);

    int deleteByName(String ClassName);

    List<ClassRoom> selectAll();
}
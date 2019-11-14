package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.College;

import java.util.List;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    List<College> selectAll();

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    int deleteByName(String collegeName);
}
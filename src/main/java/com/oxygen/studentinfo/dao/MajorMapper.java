package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Major;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    int deleteByName(String majorName);

    List<Major> selectAll();

}
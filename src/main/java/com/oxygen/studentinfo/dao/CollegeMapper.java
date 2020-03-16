package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.College;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer id);

    College selectByName(String name);

    List<College> selectAll();

    List<College> selectAllByPage(Map<String, Object> param);

    List<College> search(String key);

    List<College> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}
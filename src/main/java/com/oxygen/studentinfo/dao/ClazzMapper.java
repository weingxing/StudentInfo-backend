package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Clazz;

import java.util.List;
import java.util.Map;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    Clazz selectByName(String name);

    List<Clazz> selectAll();

    List<Clazz> selectAllByPage(Map<String, Object> param);

    List<Clazz> search(String key);

    List<Clazz> searchByPage(Map<String, Object> param);

    List<Clazz> getGrade();

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);
}
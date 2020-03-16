package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Major;

import java.util.List;
import java.util.Map;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    Major selectByName(String name);

    List<Major> selectAll();

    List<Major> selectAllByPage(Map<String, Object> param);

    List<Major> search(String key);

    List<Major> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
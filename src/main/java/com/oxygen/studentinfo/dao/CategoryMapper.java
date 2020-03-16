package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    Category selectByName(String name);

    List<Category> selectAll();

    List<Category> selectAllByPage(Map<String, Object> param);

    List<Category> search(String keyword);

    List<Category> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
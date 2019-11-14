package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int deleteByName(String categoryName);

    List<Category> selectAll();
}
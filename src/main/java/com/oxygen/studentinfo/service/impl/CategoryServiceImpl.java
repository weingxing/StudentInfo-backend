package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.CategoryMapper;
import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean addCategory(Category category) {
        int res = categoryMapper.insert(category);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteCategoryByID(int id) {
        int res = categoryMapper.deleteByPrimaryKey(id);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteCategoryByName(String name) {
        int res = categoryMapper.deleteByName(name);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updateCategoryNameByID(Category category) {
        int res = categoryMapper.updateByPrimaryKey(category);

        if (res >= 1)
            return true;
        return false;
    }
}

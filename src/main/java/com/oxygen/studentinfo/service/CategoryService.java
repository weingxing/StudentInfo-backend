package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.Category;

import java.util.List;

public interface CategoryService {
    public boolean addCategory(Category category);
    public boolean deleteCategoryByID(int id);
    public boolean deleteCategoryByName(String name);
    public boolean updateCategoryNameByID(Category category);
    public List<Category> findAllCategory();
    public Category findById(int id);
}

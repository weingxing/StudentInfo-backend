package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.Category;

public interface CategoryService {
    public boolean addCategory(Category category);
    public boolean deleteCategoryByID(int id);
    public boolean deleteCategoryByName(String name);
    public boolean updateCategoryNameByID(Category category);
}

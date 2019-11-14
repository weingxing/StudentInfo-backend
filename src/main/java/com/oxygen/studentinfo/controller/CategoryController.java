package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.Category;
import com.oxygen.studentinfo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oxygen
 * @data 2019/11/14
 *
 * 类别控制类
 */

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserController userController;


    @GetMapping("/addCategory")
    public Object addCategory(@RequestParam(value = "categoryName")String categoryName,
                              @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            Category category = new Category();
            category.setCategoryName(categoryName);

           if(categoryService.addCategory(category))
               return "FINISHED";
           else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/getAllCategory")
    public Object getAllCategory() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/getCategoryById")
    public Object getCategoryById(@RequestParam(value = "categoryId")int categoryId) {
        return categoryService.findById(categoryId);
    }

    @GetMapping("/deleteCategory")
    public Object deleteCategory(@RequestParam(value = "categoryId")int categoryId,
                                 @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(categoryService.deleteCategoryByID(categoryId))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/updateCategoryName")
    public Object updateCategoryName(@RequestParam(value = "categoryId")int categoryId,
                                     @RequestParam(value = "newName")String newName,
                                     @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            Category category = new Category();
            category.setCategoryName(newName);
            category.setCategoryId(categoryId);

            if(categoryService.updateCategoryNameByID(category))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }
}

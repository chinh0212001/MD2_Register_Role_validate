package rikkei.academy.controller;

import rikkei.academy.model.Category;
import rikkei.academy.service.category.CategoryServiceIMPL;
import rikkei.academy.service.category.ICategoryService;

import java.util.List;

public class CategoryController {
    private ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> showListCategory(){
        return categoryService.findAll();
    }
    public void createCategory(Category category){
        categoryService.save(category);
        showListCategory();
    }
}

package rikkei.academy.view;

import rikkei.academy.Config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;

import java.util.List;

public class ViewCategory {
    private CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.showListCategory();
    public void fromCreateCategory(){
        int id ;
        if (categoryList.size()==0){
            id = 1;
        }else {
            id = categoryList.get(categoryList.size()-1).getId()+1;
        }
        System.out.println("Enter The name Category: ");
        String name = Config.scanner().nextLine();
        Category category = new Category(id,name);
        categoryController.createCategory(category);
        System.out.println("LIST Category ===>" + categoryList);
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")){
            new Main();
        }
    }
}


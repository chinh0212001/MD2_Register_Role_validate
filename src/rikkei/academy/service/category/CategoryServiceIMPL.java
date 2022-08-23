package rikkei.academy.service.category;

import rikkei.academy.Config.Config;
import rikkei.academy.model.Category;
import rikkei.academy.model.User;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import java.util.List;

public class CategoryServiceIMPL implements  ICategoryService{
    private IUserService userService = new UserServiceIMPL();
    public static  String PATH_File = "C:\\Users\\Chinh\\IdeaProjects\\MD2_validate\\src\\rikkei\\academy\\database\\category.txt";
    public static List<Category> categoryList = new Config<Category>().readFile(PATH_File);

    @Override
    public List findAll() {
        new Config<Category>().writeFile(PATH_File,categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        User user = userService.getCurrentUser();
        category.setUser(user);
        categoryList.add(category);
    }
}

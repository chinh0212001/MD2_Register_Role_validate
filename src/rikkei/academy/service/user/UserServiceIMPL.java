package rikkei.academy.service.user;

import rikkei.academy.Config.Config;
import rikkei.academy.model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public static String PATH_FILE = "C:\\Users\\Chinh\\IdeaProjects\\MD2_validate\\src\\rikkei\\academy\\database\\user.txt";
    public static List<User> userList = new Config<User>().readFile(PATH_FILE);
    @Override
    public List<User> findAll() {
        new Config<User>().writeFile(PATH_FILE,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(userList.get(i).getEmail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public User getCurrentUser() {
        if (new Config<User>().readFile(Config.PAth_file2) != null) {
            User user = new Config<User>().readFile(Config.PAth_file2).get(0);
            return user;
        }
        return null;
    }

}

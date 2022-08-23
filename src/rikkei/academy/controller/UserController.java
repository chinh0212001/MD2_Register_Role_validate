package rikkei.academy.controller;
import rikkei.academy.Config.Config;
import rikkei.academy.dto.request.SignInDTO;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessenger;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.role.IRoleService;
import rikkei.academy.service.role.RoleServiceIMPL;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.service.user.UserServiceIMPL;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private IUserService iUserService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();
    public List<User> showListUser(){
        return iUserService.findAll();
    }
    public String register(SignUpDTO signUpDTO){
        if (iUserService.existedByUsername(signUpDTO.getUsername())){
            return ("username_existed");
        }
        if (iUserService.existedByEmail(signUpDTO.getEmail())){
            return ("email_existed");
        }
        Set<String> strRole = signUpDTO.getStrRoles();
        Set<Role> roles = new HashSet<>();
        strRole.forEach(role->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM);
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER);
                    roles.add(userRole);
            }
        });
        User user = new User(signUpDTO.getId(),signUpDTO.getName(),signUpDTO.getUsername(),
                signUpDTO.getEmail(),signUpDTO.getPassword(),roles);
        iUserService.save(user);
        showListUser();
        return ("success");
    }
    public ResponseMessenger Login(SignInDTO signInDTO){
        if (iUserService.checkLogin(signInDTO.getUsername(),signInDTO.getPassword())){
            User user = iUserService.findByUsername(signInDTO.getUsername());
            List<User> userLogin = new ArrayList<>();
            userLogin.add(user);
            new Config<User>().writeFile(Config.PAth_file2,userLogin);
            return new ResponseMessenger("Login_success");
        }else {
            return new ResponseMessenger("Login_failed");
        }
    }
    public User getCurrentUser(){
        return iUserService.getCurrentUser();
    }
}

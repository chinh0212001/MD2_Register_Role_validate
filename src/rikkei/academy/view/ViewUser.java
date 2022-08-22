package rikkei.academy.view;

import rikkei.academy.Config.Config;

import rikkei.academy.controller.UserController;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ViewUser {
    UserController userController = new UserController();
    List<User> userList = userController.showListUser();
    public ViewUser(){
    }
    public  void formRegister(){
        System.out.println("************FORM REGISTER****************");
        int id;
        if(userList.size()==0){
            id = 1;
        } else {
            id = userList.get(userList.size()-1).getId()+1;
        }
        //NAME
        String name;
        boolean validateName;
        while (true){
            System.out.println("Enter the name: ");
            name = Config.scanner().nextLine();
            validateName = Pattern.matches("[A-Z][a-zA-Z[\\s]]{1,10}",name);
            if(validateName){
                break;
            } else {
                System.err.println("The name failed! Please try again!");
            }
        }
        //USERNAME
        String username;
        boolean validateUsername;
        while (true){
            System.out.println("Enter the username: ");
            username = Config.scanner().nextLine();
            validateUsername = Pattern.matches("[a-zA-Z0-9]{1,40}",username);
            if(validateUsername){
                break;
            } else {
                System.err.println("The username failed! Please try again!");
            }
        }
        //EMAIL
        String email;
        boolean validateEmail;
        while (true){
            System.out.println("Enter the email: ");
            email = Config.scanner().nextLine();
            validateEmail = Pattern.matches("^(.+)@(.+)$",email);
            if(validateEmail){
                break;
            } else {
                System.err.println("The email failed! Please try again!");
            }
        }
        //PASSWORD
        String password;
        boolean validatePassword;
        while (true){
            System.out.println("Enter the password: ");
            password = Config.scanner().nextLine();
            validatePassword = Pattern.matches("[a-zA-Z0-9]{1,40}",password);
            if(validatePassword){
                break;
            } else {
                System.err.println("The username failed! Please try again!");
            }
        }
        System.out.println("Nhập vào Role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRoles = new HashSet<>();
        strRoles.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(id, name, username,email,password,strRoles);
        // lấy ra đối tượng massage từ controller đổ về để check validate các trường hợp trùng lặp trong data
        String check_existed = userController.register(signUpDTO);
        // in ra màu cho sout
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        if(check_existed.equals("user_exited")){
            System.err.println("The username is exited! Please try again!");
        } else  if(check_existed.equals("email_existed")){
            System.err.println("The email is exited! Please try again!");
        } else if(check_existed.equals("success")){
            System.out.println(ANSI_RESET+"CREATE USER SUCCESS!!!!!" + ANSI_RESET);
            System.out.printf("CHECK LIST => "+userController.showListUser());
//            new Main();
        }
    }
    public void showListUser(){
        System.out.println(userController.showListUser());
    }
}

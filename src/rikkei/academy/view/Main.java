package rikkei.academy.view;


import rikkei.academy.Config.Config;
import rikkei.academy.service.role.RoleServiceIMPL;

public class Main {
    public Main(){
        new RoleServiceIMPL().findAll();
        System.out.println(new RoleServiceIMPL().findAll());
        System.out.println("1. Register");
        System.out.println("2. Show List User");
        int choiceMenu = Config.scanner().nextInt();
        switch (choiceMenu){
            case 1:
                new ViewUser().formRegister();
                break;
            case 2:
                new ViewUser().showListUser();
                break;


        }
    }
    public static void main(String[] args) {
        new Main();
    }
}

package rikkei.academy.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String name;
    private User user;

    public Category() {
    }

    public Category(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}

package model;

import java.util.ArrayList;

public class Person {
    private String ID;
    private String name;
    private String username;
    private String password;

    public Person(String ID, String name,String username,String password) {
        this.ID = ID;
        this.name = name;
        this.username=username;
        this.password=password;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

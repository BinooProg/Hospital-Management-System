package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    private String ID;
    private String name;
    private String username;
    private String password;
    private int age;

    public Person(String ID, String name, String username, String password, int age) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static boolean isRegistered(String username , String password){
        ArrayList<Person> users = new ArrayList<>();
        users.addAll((ArrayList<Person>) Serialize.deSerializeList("accountants"));
        users.addAll((ArrayList<Person>) Serialize.deSerializeList("doctors"));
        users.addAll((ArrayList<Person>) Serialize.deSerializeList("pharmacists"));
        users.addAll((ArrayList<Person>) Serialize.deSerializeList("receptionists"));
        for (Person p : users){
            if(p.getUsername().equals(username) && p.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

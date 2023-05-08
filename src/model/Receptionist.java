package model;

public class Receptionist extends Person {


    public Receptionist(String ID, String name, String username, String password, int age) {
        super(ID, name, username, password, age);
    }

    public String toString() {
        return "Receptionist ID: " + getID() + " name: " + getName() + " username: " + getUsername() + " password: " + getPassword() + " age: " + getAge();
    }
}

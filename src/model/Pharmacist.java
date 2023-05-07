package model;

public class Pharmacist extends Person{


    public Pharmacist(String ID, String name, String username, String password, int age) {
        super(ID, name, username, password, age);
    }
    public String toString(){
        return "Pharmacist ID: "+getID()+" name: "+getName()+" username: "+getUsername()+" password: "+getPassword()+" age: "+getAge();
    }
}

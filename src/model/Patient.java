package model;

import java.io.Serializable;

public class Patient implements Serializable {
    private String ID;
    private String name;
    private int age;


    public Patient(String ID, String name,int age) {
        this.ID=ID;
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Patient ID: "+getID()+" name: "+getName()+" age: "+age;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

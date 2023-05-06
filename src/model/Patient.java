package model;

import java.io.Serializable;

public class Patient implements Serializable {
    String ID;
    String name;
    int age;


    public Patient(String ID, String name,int age) {
        this.ID=ID;
        this.name=name;
        this.age=age;
    }
}

package model;

import java.util.ArrayList;

public class Person {
    private String ID;
    private String name;
    ArrayList<Person> persons=new ArrayList<Person>();

    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

}

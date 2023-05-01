package model;


import java.util.ArrayList;

public class Doctor extends Person {
    ArrayList<Person> docPatients=new ArrayList<Person>();

    public Doctor(String ID, String name, String username, String password) {
        super(ID, name, username, password);
    }

    public void addPatient(Patient p){
    docPatients.add(p);
    }
}

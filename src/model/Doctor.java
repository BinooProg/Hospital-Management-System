package model;


import java.util.ArrayList;

public class Doctor extends Person {
    public Doctor(String ID, String name, String username, String password) {
        super(ID, name);
        super.persons.add(this);
    }

    ArrayList<Person> docPatients=new ArrayList<Person>();
    public void addPatient(Patient p){
    docPatients.add(p);
    }
}

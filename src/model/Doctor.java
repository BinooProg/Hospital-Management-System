package model;


import java.util.ArrayList;

public class Doctor extends Person {
    boolean status = true;
    ArrayList<Person> docPatients=new ArrayList<>();

    public Doctor(String ID, String name, String username, String password) {
        super(ID, name, username, password);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Person> getDocPatients() {
        return docPatients;
    }

    public void setDocPatients(ArrayList<Person> docPatients) {
        this.docPatients = docPatients;
    }
}

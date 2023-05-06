package model;
import java.util.ArrayList;

public class Doctor extends Person {
    boolean available;
    ArrayList<Patient> docPatients=new ArrayList<>();

    public Doctor(String ID, String name, String username, String password) {
        super(ID, name, username, password);
        available=true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public ArrayList<Patient> getDocPatients() {
        return docPatients;
    }

    public void setDocPatients(ArrayList<Patient> docPatients) {
        this.docPatients = docPatients;
    }
    public void addPatient(Patient p){
        docPatients.add(p);
    }
}

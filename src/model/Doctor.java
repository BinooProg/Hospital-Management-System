package model;
import java.util.ArrayList;

public class Doctor extends Person implements Comparable<Doctor> {
    boolean available;
    private int salary;
    int noOfPatients;
    String depID;
    ArrayList<Patient> docPatients = new ArrayList<>();

    public Doctor(String ID, String name, String username, String password, int age, int salary, String depID) {
        super(ID, name, username, password, age);
        this.salary = salary;
        this.depID=depID;
        available=true;
        noOfPatients=0;
    }

    public void addPatient(Patient p){
        docPatients.add(p);
        noOfPatients++;
    }
    public String toString() {
        return "Doctor ID: " + getID() + " name: " + getName() + " age: " + getAge() + " username: " + getUsername() + " password: " + getPassword()+" department id: "+getDepID();
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNoOfPatients() {
        return noOfPatients;
    }

    public void setNoOfPatients(int noOfPatients) {
        this.noOfPatients = noOfPatients;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    @Override
    public int compareTo(Doctor d) {
        return this.getNoOfPatients()-d.getNoOfPatients();
    }
}
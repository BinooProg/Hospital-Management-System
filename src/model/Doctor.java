package model;

import java.util.ArrayList;

public class Doctor extends Person implements Comparable<Doctor> {
    boolean available;
    private int salary;
    private String phoneNumb;
    int noOfPatients;
    ArrayList<Patient> docPatients = new ArrayList<>();

    public Doctor(String ID, String name, String username, String password, int age, int salary, String phoneNumb) {
        super(ID, name, username, password, age);
        this.salary = salary;
        this.phoneNumb = phoneNumb;
        noOfPatients=0;
    }

    public String toString() {
        return "Doctor ID: " + getID() + " name: " + getName() + " age: " + getAge() + " username: " + getUsername() + " passwrod: " + getPassword() + " phoneNumb: " + getPhoneNumb();
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

    public void addPatient(Patient p) {
        docPatients.add(p);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public int getNoOfPatients() {
        return noOfPatients;
    }

    public void setNoOfPatients(int noOfPatients) {
        this.noOfPatients = noOfPatients;
    }

    @Override
    public int compareTo(Doctor d) {
        return this.getNoOfPatients()-d.getNoOfPatients();
    }
}
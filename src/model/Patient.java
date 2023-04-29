package model;

public class Patient extends Person{
    private static int NOPatients=0;
    public Patient(String ID, String name) {
        super(ID, name);
        NOPatients++;
    }
}

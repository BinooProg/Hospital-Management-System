package model;

public class Patient extends Person{
    private static int NOPatients=0;

    public Patient(String ID, String name, String username, String password) {
        super(ID, name, username, password);
        NOPatients++;
    }
}

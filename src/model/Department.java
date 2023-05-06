package model;

import java.util.ArrayList;

public class Department {
    private String depID;
    private String depName;
    ArrayList<Person> depDoctors=new ArrayList<>();

    public Department(String depID, String depName) {
        this.depID = depID;
        this.depName = depName;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public ArrayList<Person> getDepDoctors() {
        return depDoctors;
    }

    public void setDepDoctors(ArrayList<Person> depDoctors) {
        this.depDoctors = depDoctors;
    }
}

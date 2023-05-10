package model;

import javax.print.Doc;
import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable {
    private String ID;
    private String Name;
    ArrayList<Doctor> depDoctors=new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    public Department(String ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public void addDoctor(Doctor d){
        depDoctors.add(d);
    }
    public String toString() {
        return "Department id: " + getID() + " name: " + getName();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room r){
    rooms.add(r);
    }

}

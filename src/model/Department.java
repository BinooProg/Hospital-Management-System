package model;
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

    public void addRoom(Room r){
    rooms.add(r);
    }

    public static void deleteDepartment(String id){
        ArrayList<Department> dd=(ArrayList<Department>)Serialize.deSerializeList("departments");
        ArrayList<Doctor> ee=(ArrayList<Doctor>)Serialize.deSerializeList("doctors");
        boolean found=false;
        for (Department d : dd){
            if(d.getID().equals(id)){
                found=true;
                dd.remove(d);
                ee.removeIf(e -> e.getDepID().equals(id));
                d.getDepDoctors().removeIf(e -> e.getDepID().equals(id));
                break;
            }
            break;
        }
        if(!found)
            System.out.println("Department not found");
        Serialize.serializeList("departments",dd);
        Serialize.serializeList("doctors",ee);
    }

    public ArrayList<Doctor> getDepDoctors() {
        return depDoctors;
    }
}

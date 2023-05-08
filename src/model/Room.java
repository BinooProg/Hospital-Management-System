package model;

import java.io.Serializable;

public class Room implements Serializable {
    private String ID;
    private String name;

    public Room(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

        public String toString(){
        return "Room id: "+getID()+" name: "+getName();
        }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

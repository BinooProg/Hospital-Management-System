package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Pharmaceutical implements Serializable {
    private String name;
    private String ID;
    private int price;
    private int stock;

    public Pharmaceutical(String name, String ID, int price, int stock) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return "Pharmaceutical ID: " + getID() + " name: " + getName() + " price: " + getPrice() + " stock: " + getStock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void deletePharmaceutical(String id){
        ArrayList<Patient> pp = (ArrayList<Patient>) Serialize.deSerializeList("patients");
        ArrayList<Pharmaceutical> dd = (ArrayList<Pharmaceutical>) Serialize.deSerializeList("pharmaceuticals");
        boolean found=false;
        for (Pharmaceutical d: dd){
            if(d.getID().equals(id)){
                found=true;
                dd.remove(d);
                for (Patient p : pp){
                    for (Pharmaceutical p1 : p.getPharmaceuticals()){
                        p.getPharmaceuticals().remove(p);
                    }
                }

                break;
            }
        }
        if(!found)
            System.out.println("Pharmaceutical not found.");
        Serialize.serializeList("patients",pp);
        Serialize.serializeList("pharmaceuticals",dd);
    }
}

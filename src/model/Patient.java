package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {
    private String ID;
    private String name;
    private int age;
    private  String diagnosis;
    boolean paymentStatus;
    ArrayList<Pharmaceutical> pharmaceuticals=new ArrayList<>();

    public Patient(String ID, String name,int age) {
        this.ID=ID;
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "Patient ID: "+getID()+" name: "+getName()+" age: "+age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Pharmaceutical> getPharmaceuticals() {
        return pharmaceuticals;
    }

    public void setPharmaceuticals(ArrayList<Pharmaceutical> pharmaceuticals) {
        this.pharmaceuticals = pharmaceuticals;
    }
    public void addPharmaceutical(Pharmaceutical p){
        pharmaceuticals.add(p);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public static void  deletePatient(String id){
        ArrayList<Patient> pp = (ArrayList<Patient>) Serialize.deSerializeList("patients");
        ArrayList<Doctor> dd = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
        boolean found=false;
        for (Patient p: pp){
            if(p.getID().equals(id)){
                found=true;
                pp.remove(p);
                for (Doctor d : dd){
                    d.getDocPatients().removeIf(p1 -> p1.getID().equals(id));
                    break;
                }
                break;
            }
        }
        if(!found)
            System.out.println("Patient not found.");
        Serialize.serializeList("patients",pp);
        Serialize.serializeList("doctors",dd);
    }
}

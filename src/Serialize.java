import model.*;

import java.io.*;
import java.util.ArrayList;

public class Serialize {
    public static String filePath = "src/data/";

    public static void serializeList(String fileName, ArrayList<?> list) {
        try {
            FileOutputStream fout = new FileOutputStream(filePath + fileName + ".dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(list);
            oout.close();
            fout.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Cannot serialize this array");
        }
    }

    public static ArrayList<?> deSerializeList(String fileName) {
        try {
            FileInputStream fin = new FileInputStream(filePath + fileName + ".dat");
            ObjectInputStream oin = new ObjectInputStream(fin);
            switch (fileName) {
                case "accountants":
                    return (ArrayList<Accountant>) oin.readObject();
                case "departments":
                    return (ArrayList<Department>) oin.readObject();
                case "doctors":
                    return (ArrayList<Doctor>) oin.readObject();
                case "patients":
                    return (ArrayList<Patient>) oin.readObject();
                case "pharmaceuticals":
                    return (ArrayList<Pharmaceutical>) oin.readObject();
                case "pharmacists":
                    return (ArrayList<Pharmacist>) oin.readObject();
                case "receptionists":
                    return (ArrayList<Receptionist>) oin.readObject();
                case "rooms":
                    return (ArrayList<Room>) oin.readObject();
            }
            oin.close();
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Cannot deSerialize this array");
        }
        return null;
    }
}


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

import java.util.*;


public class Main extends Application {
    Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        launch(args);
    }

    static Stage loginStage = new Stage();
    @FXML
    private TextField epassword;
    @FXML
    private Label error;
    @FXML
    private TextField eusername;
    String username;
    String password;

    @FXML
    void Login(ActionEvent event) {

        String aUsername = "aa";
        String aPassword = "aa";
        username = eusername.getText();
        password = epassword.getText();


        boolean found = false;
        ArrayList<ArrayList<Person>> users = new ArrayList<>();
        users.add((ArrayList<Person>) Serialize.deSerializeList("accountants"));
        users.add((ArrayList<Person>) Serialize.deSerializeList("doctors"));
        users.add((ArrayList<Person>) Serialize.deSerializeList("pharmacists"));
        users.add((ArrayList<Person>) Serialize.deSerializeList("receptionists"));
        if (aUsername.equals(username) && aPassword.equals(password)) {
            loginStage.hide();
            found = true;
            showAdminMenu();
        }
        if (!found) {
            for (ArrayList<Person> ar : users) {
                for (Person p : ar) {
                    if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                        found = true;
                        loginStage.hide();
                        switch (p.getClass().getSimpleName()) {
                            case "Accountant":
                                showAccountantMenu();
                                break;
                            case "Doctor":
                                showDoctorMenu();
                                break;
                            case "Pharmacist":
                                showPharmacistMenu();
                                break;
                            case "Receptionist":
                                showReceptionistMenu();
                                break;
                        }
                    }
                }
            }
        }
        if (!found) error.setVisible(true);

    }

    private void showAdminMenu() {
        boolean b = true;
        while (b) {
            System.out.println("1. Manage patients");
            System.out.println("2. Manage doctors");
            System.out.println("3. Manage accountants");
            System.out.println("4. Manage pharmacists");
            System.out.println("5. Manage receptionists");
            System.out.println("6. Manage pharmaceuticals");
            System.out.println("7. Manage departments");
            System.out.println("8. Manage rooms");
            System.out.println("9. Exit");
            int temp = kb.nextInt();
            switch (temp) {
                case 1:
                    boolean b1 = true;
                    while (b1) {
                        System.out.println("1. Add new patient");
                        System.out.println("2. Delete existent patient");
                        System.out.println("3. View all patients");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter patient ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Patient> arr = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                                boolean bb = false;
                                for (Patient p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter patient name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter patient age: ");
                                int age = kb.nextInt();
                                arr.add(new Patient(id, name, age));
                                Serialize.serializeList("patients", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter patient ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                Patient.deletePatient(id);
                                break;
                            }
                            case 3: {
                                ArrayList<Patient> p = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                                for (Patient d : p) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b1 = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean b2 = true;
                    while (b2) {
                        System.out.println("1. Add new doctor");
                        System.out.println("2. Delete existent doctor");
                        System.out.println("3. View all doctors");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter doctor ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Doctor> arr = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                ArrayList<Department> darr = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                boolean bb = false;
                                for (Doctor p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter doctor name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter doctor age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter doctor username: ");
                                String username = kb.next();
                                kb.nextLine();
                                System.out.print("Enter doctor password: ");
                                String password = kb.next();
                                kb.nextLine();
                                System.out.print("Enter doctor salary: ");
                                int salary = kb.nextInt();
                                System.out.print("Enter doctor department id: ");
                                String depID = kb.next();
                                kb.nextLine();
                                Doctor d1 = new Doctor(id, name, username, password, age, salary, depID);
                                boolean b21 = true;
                                for (Department d : darr) {
                                    if (d.getID().equals(depID)) {
                                        d.addDoctor(d1);
                                        arr.add(d1);
                                        b21 = false;
                                    }
                                }
                                if (b21)
                                    System.out.println("Department doesn't exist !");
                                Serialize.serializeList("doctors", arr);
                                Serialize.serializeList("departments", darr);
                                break;
                            }
                            case 2:
                                System.out.print("Enter doctor ID: ");
                                String id = kb.next();
                                ArrayList<Doctor> p = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                p.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("doctors", p);
                                break;
                            case 3: {
                                ArrayList<Doctor> dd = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                for (Doctor d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b2 = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean b3 = true;
                    while (b3) {
                        System.out.println("1. Add new accountant");
                        System.out.println("2. Delete existent accountant");
                        System.out.println("3. View all accountants");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter accountant ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Accountant> arr = (ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                boolean bb = false;
                                for (Accountant p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter accountant name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter accountant age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter accountant username: ");
                                String username = kb.next();
                                kb.nextLine();
                                System.out.print("Enter accountant password: ");
                                String password = kb.next();
                                kb.nextLine();
                                System.out.print("Enter accountant salary: ");
                                int salary = kb.nextInt();
                                arr.add(new Accountant(id, name, username, password, age, salary));
                                Serialize.serializeList("accountants", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter accountant ID: ");
                                String id = kb.next();
                                ArrayList<Accountant> p = (ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                p.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("accountants", p);
                                break;
                            }
                            case 3: {
                                ArrayList<Accountant> dd = (ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                for (Accountant d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b3 = false;
                                break;
                        }
                    }

                    break;
                case 4:
                    boolean b4 = true;
                    while (b4) {
                        System.out.println("1. Add new pharmacist");
                        System.out.println("2. Delete existent pharmacist");
                        System.out.println("3. View all pharmacist");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter pharmacist ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Pharmacist> arr = (ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                boolean bb = false;
                                for (Pharmacist p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter pharmacist name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter pharmacist age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter pharmacist username: ");
                                String username = kb.next();
                                kb.nextLine();
                                System.out.print("Enter pharmacist password: ");
                                String password = kb.next();
                                kb.nextLine();
                                arr.add(new Pharmacist(id, name, username, password, age));
                                Serialize.serializeList("pharmacists", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter pharmacist ID: ");
                                String id = kb.next();
                                ArrayList<Pharmacist> p1 = (ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                p1.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("pharmacists", p1);
                                break;
                            }
                            case 3: {
                                ArrayList<Pharmacist> dd = (ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                for (Pharmacist d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b4 = false;
                                break;
                        }
                    }

                    break;
                case 5:
                    boolean b5 = true;
                    while (b5) {
                        System.out.println("1. Add new receptionist");
                        System.out.println("2. Delete existent receptionist");
                        System.out.println("3. View all receptionist");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter receptionist ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Receptionist> arr = (ArrayList<Receptionist>) Serialize.deSerializeList("receptionists");
                                boolean bb = false;
                                for (Receptionist p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter receptionist name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter receptionist age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter receptionist username: ");
                                String username = kb.next();
                                kb.nextLine();
                                System.out.print("Enter receptionist password: ");
                                String password = kb.next();
                                kb.nextLine();
                                arr.add(new Receptionist(id, name, username, password, age));
                                Serialize.serializeList("receptionists", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter receptionist ID: ");
                                String id = kb.next();
                                ArrayList<Receptionist> p1 = (ArrayList<Receptionist>) Serialize.deSerializeList("receptionists");
                                p1.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("receptionists", p1);
                                break;
                            }
                            case 3: {
                                ArrayList<Receptionist> dd = (ArrayList<Receptionist>) Serialize.deSerializeList("receptionists");
                                for (Receptionist d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b5 = false;
                                break;
                        }
                    }
                    break;
                case 6:
                    boolean b6 = true;
                    while (b6) {
                        System.out.println("1. Add new pharmaceutical");
                        System.out.println("2. Delete existent pharmaceutical");
                        System.out.println("3. View all pharmaceutical");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter pharmaceutical ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Pharmaceutical> arr = (ArrayList<Pharmaceutical>) Serialize.deSerializeList("pharmaceuticals");
                                boolean bb = false;
                                for (Pharmaceutical p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter pharmaceutical name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter pharmaceutical price: ");
                                int price = kb.nextInt();
                                System.out.print("Enter pharmaceutical stock: ");
                                int stock = kb.nextInt();
                                arr.add(new Pharmaceutical(name, id, price, stock));
                                Serialize.serializeList("pharmaceuticals", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter pharmaceutical ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                Pharmaceutical.deletePharmaceutical(id);
                                break;
                            }
                            case 3: {
                                ArrayList<Pharmaceutical> dd = (ArrayList<Pharmaceutical>) Serialize.deSerializeList("pharmaceuticals");
                                for (Pharmaceutical d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b6 = false;
                                break;
                        }
                    }
                    break;
                case 7:
                    boolean b7 = true;
                    while (b7) {
                        System.out.println("1. Add new department");
                        System.out.println("2. Delete existent department");
                        System.out.println("3. View all department");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter department ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Department> arr = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                boolean bb = false;
                                for (Department p : arr) {
                                    if (p.getID().equals(id)) {
                                        System.out.println("Duplicated id");
                                        bb = true;
                                        break;
                                    }
                                }
                                if (bb)
                                    break;
                                System.out.print("Enter department name: ");
                                String name = kb.nextLine();
                                arr.add(new Department(id, name));
                                Serialize.serializeList("departments", arr);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter department ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                Department.deleteDepartment(id);
                                break;
                            }
                            case 3: {
                                ArrayList<Department> dd = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                for (Department d : dd) {
                                    System.out.println(d);
                                }
                                break;
                            }
                            case 4:
                                b7 = false;
                                break;
                        }
                    }
                    break;
                case 8:
                    boolean b8 = true;
                    while (b8) {
                        System.out.println("1. Add new room");
                        System.out.println("2. Delete existent room");
                        System.out.println("3. View all rooms in a specific department");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1: {
                                System.out.print("Enter room id: ");
                                String id = kb.next();
                                kb.nextLine();
                                System.out.println(id);
                                System.out.print("Enter room name: ");
                                String name = kb.next();
                                kb.nextLine();
                                System.out.print("Enter department id: ");
                                String depid = kb.next();
                                kb.nextLine();
                                System.out.println(depid);
                                Room r = new Room(id, name);
                                ArrayList<Department> arr = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                boolean b81 = false;
                                for (Department d : arr) {
                                    if (d.getID().equals(depid)) {
                                        d.addRoom(r);
                                        b81 = true;
                                    }
                                }
                                if (!b81)
                                    System.out.println("There is no such department associated with this ID");
                                Serialize.serializeList("departments", arr);

                                break;
                            }
                            case 2: {
                                System.out.print("Enter department id:");
                                String depid = kb.next();
                                kb.nextLine();
                                System.out.print("Enter room id: ");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Department> arr = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                for (Department d : arr) {
                                    if (depid.equals(d.getID())) {
                                        for (Room r : d.getRooms()) {
                                            if (r.getID().equals(id)) {
                                                d.getRooms().remove(r);
                                                break;
                                            }
                                        }
                                    }
                                }
                                Serialize.serializeList("departments", arr);
                                break;
                            }
                            case 3: {
                                System.out.print("Enter department id:");
                                String id = kb.next();
                                kb.nextLine();
                                ArrayList<Department> arr = (ArrayList<Department>) Serialize.deSerializeList("departments");
                                for (Department d : arr) {
                                    if (d.getID().equals(id)) {
                                        for (Room r : d.getRooms()) {
                                            System.out.println(r);
                                        }
                                    }
                                }
                                break;
                            }
                            case 4:
                                b8 = false;
                                break;
                        }
                    }
                    break;
                case 9:
                    exit();
                    b = false;
                    break;
            }
        }
    }

    private void showDoctorMenu() {
        Doctor d1 = null;
        ArrayList<Doctor> dd = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
        for (Doctor d : dd) {
            if (d.getUsername().equals(username) && d.getPassword().equals(password)) {
                d1 = d;
            }
        }
        boolean b1 = true;
        while (b1) {
            System.out.println("1. Serve patient");
            System.out.println("2. Show all pharmaceutical");
            System.out.println("3. Update status");
            System.out.println("4. Exit");
            int temp = kb.nextInt();
            switch (temp) {
                case 1: {
                    ArrayList<Pharmaceutical> pp = (ArrayList<Pharmaceutical>) Serialize.deSerializeList("pharmaceuticals");
                    ArrayList<Patient> pa = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                    Patient p1 = null;
                    for (Patient p : d1.getDocPatients()) {
                        System.out.println(p);
                    }

                    System.out.print("Enter patient ID: ");
                    String id = kb.next();
                    kb.nextLine();
                    boolean b11 = true;
                    for (Patient p : d1.getDocPatients()) {
                        if (p.getID().equals(id)) {
                            b11 = false;
                            p1 = p;
                        }
                    }
                    if (b11) {
                        System.out.println("Patient not found");
                        break;
                    }

                    System.out.println("Enter your patient diagnosis: ");
                    String diag = kb.next();
                    kb.nextLine();
                    System.out.print("Enter the number of pharmaceuticals: ");
                    int numb = kb.nextInt();
                    for (int i = 0; i < numb; i++) {
                        for (Pharmaceutical p : pp) {
                            System.out.println(p);
                        }
                        System.out.print("Choose pharmaceutical id: ");
                        String pID = kb.next();
                        kb.nextLine();
                        boolean b12 = true;
                        for (Pharmaceutical p : pp) {
                            if (p.getID().equals(pID) && p.getStock() > 0) {
                                b12 = false;
                                p1.addPharmaceutical(p);
                                p1.setDiagnosis(diag);
                                p1.setPaymentStatus(false);
                                p.setStock(p.getStock() - 1);
                            }
                        }
                        if (b12) {
                            System.out.println("Pharmaceutical not found");
                            break;
                        }
                    }
                    Serialize.serializeList("doctors", dd);
                    Serialize.serializeList("pharmaceuticals", pp);
                    Serialize.serializeList("patients", pa);

                    break;
                }
                case 2:
                    ArrayList<Pharmaceutical> pa = (ArrayList<Pharmaceutical>) Serialize.deSerializeList("pharmaceuticals");
                    for (Pharmaceutical p : pa) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("== Set your status ==");
                    System.out.println("Available -> 1");
                    System.out.println("Occupied -> 0");
                    int ans = kb.nextInt();
                    if (ans > 0) {
                        d1.setAvailable(true);
                    } else {
                        d1.setAvailable(false);
                    }
                    Serialize.serializeList("doctors", dd);
                    break;
                case 4:
                    b1 = false;
                    exit();
                    break;
            }
        }

    }

    private void showPharmacistMenu() {
        System.out.println("1. Serve patient");
        System.out.println("2. Show all patients");
        System.out.println("3. Show all pharmaceutical");
        System.out.println("4. Add new pharmaceutical");
        System.out.println("5. Show statistics");
        System.out.println("6. Exit");
        int temp = kb.nextInt();
        switch (temp) {
            case 1:


                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                exit();
                break;
        }
    }

    private void showReceptionistMenu() {
        boolean b1 = true;
        while (b1) {
            System.out.println("1. Serve patient");
            System.out.println("2. Exit");
            int temp = kb.nextInt();
            switch (temp) {
                case 1:
                    System.out.print("Enter patient id: ");
                    String ID = kb.next();
                    kb.nextLine();
                    System.out.print("Enter department id: ");
                    String dpID = kb.next();
                    kb.nextLine();
                    boolean b11 = false;
                    ArrayList<Doctor> arr = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                    ArrayList<Patient> pp = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                    for (Patient p : pp) {
                        if (p.getID().equals(ID)) {
                            b11 = true;
                            break;
                        }
                    }
                    boolean b12 = true;
                    if (b11) {
                        Collections.sort(arr);
                        for (Doctor d : arr) {
                            if (d.isAvailable() && d.getDepID().equals(dpID)) {
                                b12 = false;
                                System.out.println("Doctor ID: " + d.getID() + " name: " + d.getID() + " number of patients: " + d.getNoOfPatients());
                            }
                        }
                        if (b12) {
                            System.out.println("No doctor associated with this department");
                            break;
                        }
                    } else {
                        System.out.println("Patient not found !");
                        break;
                    }
                    boolean b13 = true;
                    System.out.print("Enter doctor id: ");
                    String dID = kb.next();
                    kb.nextLine();
                    boolean b14 = true;
                    for (Doctor d : arr) {
                        if (dID.equals(d.getID()) && b14) {
                            for (Patient p : pp) {
                                if (p.getID().equals(ID) && b14) {
                                    for (Patient p1 : d.getDocPatients()) {
                                        if (p1.getID().equals(ID)) {
                                            System.out.println("This patient is already assigned");
                                            b14 = false;
                                            break;
                                        }
                                    }
                                    if (b14)
                                        d.addPatient(p);
                                }
                            }
                            b13 = false;
                        }
                    }
                    if (b13) {
                        System.out.println("Doctor not found!");
                        break;
                    }
                    Serialize.serializeList("doctors", arr);

                    break;
                case 2:
                    b1 = false;
                    exit();
                    break;
            }
        }

    }

    private void showAccountantMenu() {
        System.out.println("1. Serve patient");
        System.out.println("2. Show all patients");
        System.out.println("3. Show statistics");
        System.out.println("4. Exit");
        int temp = kb.nextInt();
        ArrayList<Patient> arr = (ArrayList<Patient>) Serialize.deSerializeList("patients");
        switch (temp) {
            case 1:
                System.out.print("Enter patient id: ");
                String id = kb.next();
                kb.nextLine();
                boolean b1 = true;
                int sum=0;
                for (Patient p : arr) {
                    if (p.getID().equals(id)) {
                        b1 = false;
                        if (p.getPharmaceuticals().size()==0) {
                            System.out.println("This patient hasn't been diagnosted yet");
                        } else {
                            for (Pharmaceutical pp : p.getPharmaceuticals()) {
                                System.out.println("name: " + pp.getName() + " price: " + +pp.getPrice());
                                sum+=pp.getPrice();
                            }
                        }
                    }
                    if(b1){
                        System.out.println("There is no patient associated with this ID.");
                    } else {
                        System.out.println("The sum is = "+sum);
                    }
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                exit();
                break;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        root.setStyle("-fx-background-image: url('images/backgroundImage.jpg')");
        Scene scene = new Scene(root);
        loginStage.setScene(scene);
        loginStage.setTitle("Hospital management");
        loginStage.getIcons().add(new Image("images/Icon.png"));
        loginStage.setResizable(false);
        loginStage.show();
    }

    public void exit() {
        eusername.clear();
        epassword.clear();
        error.setVisible(false);
        loginStage.show();
    }
}

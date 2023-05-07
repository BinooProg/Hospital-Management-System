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

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


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

    @FXML
    void Login(ActionEvent event) {
        String username = eusername.getText();
        String password = epassword.getText();
        String aUsername = "aa";
        String aPassword = "aa";


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
            if(!found){
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
            if(!found)
                error.setVisible(true);

    }

    private void showAdminMenu() {
        boolean b=true;
        while (b){
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
                    boolean b1=true;
                    while (b1){
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
                                System.out.print("Enter patient name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter patient age: ");
                                int age = kb.nextInt();
                                ArrayList<Patient> p = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                                p.add(new Patient(id, name, age));
                                Serialize.serializeList("patients", p);
                                break;
                            }
                            case 2: {
                                System.out.print("Enter patient ID: ");
                                String id = kb.next();
                                ArrayList<Patient> p = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                                p.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("patients", p);
                                break;
                            }
                            case 3:{
                                ArrayList<Patient> p = (ArrayList<Patient>) Serialize.deSerializeList("patients");
                                for (Patient d:p) {
                                    System.out.println(d);
                                }
                                break;}
                            case 4:
                                b1=false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean b2=true;
                    while (b2){
                        System.out.println("1. Add new doctor");
                        System.out.println("2. Delete existent doctor");
                        System.out.println("3. View all doctors");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1:{
                                System.out.print("Enter doctor ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                System.out.print("Enter doctor name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter doctor age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter doctor username: ");
                                String username=kb.next();
                                kb.nextLine();
                                System.out.print("Enter doctor password: ");
                                String password=kb.next();
                                kb.nextLine();
                                System.out.print("Enter doctor salary: ");
                                int salary = kb.nextInt();
                                System.out.print("Enter doctor phoneNumber: ");
                                String phoneNumb = kb.next();
                                kb.nextLine();
                                ArrayList<Doctor> dd=(ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                dd.add(new Doctor(id,name,username,password,age,salary,phoneNumb));
                                Serialize.serializeList("doctors",dd);
                                break;}
                            case 2:
                                System.out.print("Enter doctor ID: ");
                                String id = kb.next();
                                ArrayList<Doctor> p = (ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                p.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("doctors",p);
                                break;
                            case 3:{
                                ArrayList<Doctor> dd=(ArrayList<Doctor>) Serialize.deSerializeList("doctors");
                                for (Doctor d:dd) {
                                    System.out.println(d);
                                }
                                break;}
                            case 4:
                                b2=false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean b3=true;
                    while(b3){
                        System.out.println("1. Add new accountant");
                        System.out.println("2. Delete existent accountant");
                        System.out.println("3. View all accountants");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1:{
                                System.out.print("Enter accountant ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                System.out.print("Enter accountant name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter accountant age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter accountant username: ");
                                String username=kb.next();
                                kb.nextLine();
                                System.out.print("Enter accountant password: ");
                                String password=kb.next();
                                kb.nextLine();
                                System.out.print("Enter accountant salary: ");
                                int salary = kb.nextInt();
                                ArrayList<Accountant> dd=(ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                dd.add(new Accountant(id,name,username,password,age,salary));
                                Serialize.serializeList("accountants",dd);
                                break;}
                            case 2:{
                                System.out.print("Enter accountant ID: ");
                                String id = kb.next();
                                ArrayList<Accountant> p = (ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                p.removeIf(d -> d.getID().equals(id));
                                Serialize.serializeList("accountants",p);
                                break;}
                            case 3:{
                                ArrayList<Accountant> dd=(ArrayList<Accountant>) Serialize.deSerializeList("accountants");
                                for (Accountant d:dd) {
                                    System.out.println(d);
                                }
                                break;}
                            case 4:
                                b3=false;
                                break;
                        }
                    }

                    break;
                case 4:
                    boolean b4=true;
                    while(b4){
                        System.out.println("1. Add new pharmacist");
                        System.out.println("2. Delete existent pharmacist");
                        System.out.println("3. View all pharmacist");
                        System.out.println("4. Exit");
                        temp = kb.nextInt();
                        switch (temp) {
                            case 1:{
                                System.out.print("Enter pharmacist ID: ");
                                String id = kb.next();
                                kb.nextLine();
                                System.out.print("Enter pharmacist name: ");
                                String name = kb.nextLine();
                                System.out.print("Enter pharmacist age: ");
                                int age = kb.nextInt();
                                System.out.print("Enter pharmacist username: ");
                                String username=kb.next();
                                kb.nextLine();
                                System.out.print("Enter pharmacist password: ");
                                String password=kb.next();
                                kb.nextLine();
                                System.out.print("Enter pharmacist salary: ");
                                int salary = kb.nextInt();
                                ArrayList<Pharmacist> dd=(ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                dd.add(new Pharmacist(id,name,username,password,age));
                                Serialize.serializeList("pharmacists",dd);
                                break;}
                            case 2:{
                                System.out.print("Enter pharmacist ID: ");
                                String id = kb.next();
                                ArrayList<Pharmacist> p1 = (ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                for (Pharmacist d:p1) {
                                    if(d.getID().equals(id)){
                                        p1.remove(d);
                                    }
                                }
                                Serialize.serializeList("pharmacists",p1);
                                break;}
                            case 3:{
                                ArrayList<Pharmacist> dd=(ArrayList<Pharmacist>) Serialize.deSerializeList("pharmacists");
                                for (Pharmacist d:dd) {
                                    System.out.println(d);
                                }
                                break;}
                            case 4:
                                b4=false;
                                break;
                        }
                    }

                    break;
                case 5:
                    System.out.println("1. Add new receptionist");
                    System.out.println("2. Delete existent receptionist");
                    System.out.println("3. View all receptionists");
                    System.out.println("4. Exit");
                    temp = kb.nextInt();
                    switch (temp) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }

                    break;
                case 6:
                    System.out.println("1. Add new pharmaceutical");
                    System.out.println("2. Delete existent pharmaceutical");
                    System.out.println("3. View all pharmaceuticals");
                    System.out.println("4. Exit");
                    temp = kb.nextInt();
                    switch (temp) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }

                    break;
                case 7:
                    System.out.println("1. Add new department");
                    System.out.println("2. Delete existent department");
                    System.out.println("3. View all departments");
                    System.out.println("4. Exit");
                    temp = kb.nextInt();
                    switch (temp) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }

                    break;
                case 8:
                    System.out.println("1. Add new room");
                    System.out.println("2. Delete existent room");
                    System.out.println("3. View all rooms");
                    System.out.println("4. Exit");
                    temp = kb.nextInt();
                    switch (temp) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }

                    break;
                case 9:
                    exit();
                    b=false;
                    break;
            }
        }


    }

    private void showDoctorMenu() {
        boolean b=true;
        while (b){
            System.out.println("1. Serve patient");
            System.out.println("2. Show all pharmaceutical");
            System.out.println("3. Update status");
            System.out.println("4. Exit");
            int temp = kb.nextInt();
            switch (temp) {
                case 1:


                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    exit();
                    b=false;
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
        System.out.println("1. Serve patient");
        System.out.println("2. Exit");
        int temp = kb.nextInt();
        switch (temp) {
            case 1:
                System.out.print("Enter patient id: ");
                int eID = kb.nextInt();
                break;
            case 2:
                exit();
                break;
        }
    }

    private void showAccountantMenu() {
        System.out.println("1. Serve patient");
        System.out.println("2. Show all patients");
        System.out.println("3. Show statistics");
        System.out.println("4. Exit");
        int temp = kb.nextInt();
        switch (temp) {
            case 1:


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
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

import javax.print.Doc;
import java.util.ArrayList;
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
        boolean exist = false;
        var patients = (ArrayList<Patient>) Serialize.deSerializeList("patients");
        for (var user : patients) {

        }
    }

    private void showAdminMenu() {
        System.out.println("1. Manage patients");
        System.out.println("2. Manage doctors");
        System.out.println("3. Manage accountants");
        System.out.println("4. Manage pharmacists");
        System.out.println("5. Manage receptionists");
        System.out.println("6. Manage pharmaceuticals");
        System.out.println("7. Manage departments");
        System.out.println("8. Manage rooms");
        int temp = kb.nextInt();
        switch (temp) {
            case 1:
                System.out.println("1. Add new patient");
                System.out.println("2. Delete existent patient");
                System.out.println("3. View all patients");
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
            case 2:
                System.out.println("1. Add new doctor");
                System.out.println("2. Delete existent doctor");
                System.out.println("3. View all doctors");
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
            case 3:
                System.out.println("1. Add new accountant");
                System.out.println("2. Delete existent accountant");
                System.out.println("3. View all accountants");
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
            case 4:
                System.out.println("1. Add new pharmacist");
                System.out.println("2. Delete existent pharmacist");
                System.out.println("3. View all pharmacists");
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
            case 5:
                System.out.println("1. Add new receptionist");
                System.out.println("2. Delete existent receptionist");
                System.out.println("3. View all receptionists");
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
        }


    }

    private void showDoctorMenu() {
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
                break;
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

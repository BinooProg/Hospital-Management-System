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
import java.util.Scanner;

public class Main extends Application {
    ArrayList<Person> persons=new ArrayList<>();


    Scanner kb=new Scanner(System.in);
    public static void main(String[] args) {
        launch(args);
    }
    static Stage loginStage=new Stage();
    @FXML
    private TextField epassword;

    @FXML
    private Label error;

    @FXML
    private TextField eusername;

    @FXML
    void Login(ActionEvent event) {
        persons.add(new Admin("ad","awd","a","a"));
        persons.add(new Doctor("ahmed","shahid","d","d"));
        persons.add(new Pharmacist("ahmed","shahid","p","p"));
    String username=eusername.getText();
    String password=epassword.getText();
    boolean exist=false;
    for(Person p : persons){
        if(username.equals(p.getUsername()) && password.equals(p.getPassword())){
            exist=true;
            String ptype=p.getClass().getSimpleName();
            loginStage.hide();
            switch (ptype) {
                case "Admin" -> showAdminMenu();
                case "Doctor" -> showDoctorMenu();
                case "Pharmacist" -> showPharmacistMenu();
                case "Receptionist" -> showReceptionistMenu();
                case "Accountant" -> showAccountantMenu();

            }
        }
        if (!exist) {
            error.setVisible(true);
        }
    }
    }
    private void showAdminMenu(){
        System.out.println();
    }private void showDoctorMenu(){
        System.out.println("1_ Serve patient");
        System.out.println("2_ Show all pharmaceutical");
        System.out.println("3_ Update status");
        System.out.println("4_ Exit");
        int temp= kb.nextInt();
        switch (temp){
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
    }private void showPharmacistMenu(){
        System.out.println("1_ Serve patient");
        System.out.println("2_ Show all patients");
        System.out.println("3_ Show all pharmaceutical");
        System.out.println("4_ Add new pharmaceutical");
        System.out.println("5_ Show statistics");
        System.out.println("6_ Exit");
        int temp= kb.nextInt();
        switch (temp){
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
    }private void showReceptionistMenu(){
        System.out.println("1_ Serve patient");
        System.out.println("2_ Exit");
        int temp= kb.nextInt();
        switch (temp){
            case 1:
            System.out.print("Enter patient id: ");
            int eID=kb.nextInt();
            break;
            case 2:
                exit();
            break;
        }
    }
    private void showAccountantMenu(){
        System.out.println("1_ Serve patient");
        System.out.println("2_ Show all patients");
        System.out.println("3_ Show statistics");
        System.out.println("4_ Exit");
        int temp= kb.nextInt();
        switch (temp){
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
        Parent root= FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        root.setStyle("-fx-background-image: url('images/backgroundImage.jpg')");
        Scene scene=new Scene(root);
        loginStage.setScene(scene);
        loginStage.setTitle("Hospital management");
        loginStage.getIcons().add(new Image("images/Icon.png"));
        loginStage.setResizable(false);
        loginStage.show();
    }
    public void exit(){
        eusername.clear();
        epassword.clear();
        error.setVisible(false);
        loginStage.show();
    }
}

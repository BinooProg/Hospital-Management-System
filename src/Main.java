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
import model.Doctor;
import model.Person;
import model.Pharmacist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main extends Application {

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
        ArrayList<Person> persons=new ArrayList<Person>();
        Iterator<Person> personItr=persons.iterator();
        Doctor d=new Doctor("ahmed","shahid","a","a");
        Pharmacist p1=new Pharmacist("ahmed","shahid","b","b");
        persons.add(d);
        persons.add(p1);
    String username=eusername.getText();
    String password=epassword.getText();
    boolean exist=false;
    for(Person p : persons){
        if(username.equals(p.getUsername()) && password.equals(p.getPassword())){
            exist=true;
            loginStage.hide();
            System.out.println("Hello " + p.getClass().getSimpleName());
        }
        if (!exist) {
            error.setVisible(true);
        }
    }
    }
    private void showAdminMenu(){
        System.out.println();
    }private void showDoctorMenu(){
        System.out.println();
    }private void showPharmacistMenu(){
        System.out.println();
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
            break;
        }
    }
    private void showAccountantMenu(){
        System.out.println();
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
}

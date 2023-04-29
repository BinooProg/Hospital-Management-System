import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Person;

public class Main extends Application {
    String admin_username="b";
    String admin_password="123";
    public static void main(String[] args) {
        launch(args);
    }
    static Stage loginStage=new Stage();
    @FXML
    private ImageView backImage;

    @FXML
    private Label error;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void Login(ActionEvent event) {


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

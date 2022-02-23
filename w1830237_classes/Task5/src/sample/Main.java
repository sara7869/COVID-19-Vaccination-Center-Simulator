package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Patient Details Form.fxml")));
        primaryStage.setTitle("Patient Details");
        primaryStage.setScene(new Scene(root, 400, 625));
        primaryStage.show();
    }
}

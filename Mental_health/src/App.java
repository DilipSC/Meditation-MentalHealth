import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file (make sure the path is correct)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LP.fxml"));
            Parent root = loader.load();
            
            // Set the scene
            Scene scene = new Scene(root, 300, 200); // Adjust width and height as needed
            primaryStage.setTitle("Mindful Oasis");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

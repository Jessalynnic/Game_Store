package a.learning;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passTextField;
    
    @FXML
    private void loginClicked(ActionEvent event) throws IOException {
        passUsername();
            
    }
    
    public void passUsername() {
        String username = userTextField.getText();
        
        try {
            System.out.println("CSS path: " + getClass().getResource("/a/learning/learning.css"));
            System.out.println("FXML path: " + getClass().getResource("/a/learning/game.fxml"));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/a/learning/game.fxml"));
            Parent root1 = fxmlLoader.load();
            GameController gameController = fxmlLoader.getController();
            gameController.setUsername("Hello " + username + "!");

            Scene scene = new Scene(root1);

            // ✅ Apply the stylesheet manually (this bypasses FXML’s strict loader)
            URL cssUrl = getClass().getResource("/a/learning/learning.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.out.println("WARNING: CSS file not found!");
            }
            
            Stage stage = new Stage();
            stage.setTitle("GameZ Store");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error: Cant load new window");
            e.printStackTrace();
        }    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

}
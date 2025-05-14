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

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private VBox loginVBox;

    @FXML
    private VBox registerVBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private PasswordField regPassTextField;
    
    @FXML
    private void loginClicked(ActionEvent event) {
        String username = userTextField.getText().trim();
        String password = passTextField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Please enter both username and password.");
            return;
        }

        String result = UserDAO.loginUser(username, password);

        switch (result) {
            case "SUCCESS":
                showAlert(Alert.AlertType.INFORMATION, "Login successful!");
                loadGameStore(username);
                break;
            case "WRONG_PASSWORD":
                showAlert(Alert.AlertType.ERROR, "Incorrect password.");
                break;
            case "USER_NOT_FOUND":
                showAlert(Alert.AlertType.ERROR, "Username not found.");
                break;
            case "DB_ERROR":
            default:
                showAlert(Alert.AlertType.ERROR, "A database error occurred. Please try again.");
                break;
        }
    }

    public void registerBtnClicked(ActionEvent actionEvent) {
        String email = emailTextField.getText().trim();
        String username = usernameTextField.getText().trim();
        String password = regPassTextField.getText().trim();

        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Please fill in all fields.");
            return;
        }

        String result = UserDAO.registerUser(email, username, password);

        switch (result) {
            case "SUCCESS":
                showAlert(Alert.AlertType.INFORMATION, "Registration successful!");
                emailTextField.clear();
                usernameTextField.clear();
                regPassTextField.clear();

                goToLogin();
                break;
            case "USER_EXISTS":
                showAlert(Alert.AlertType.WARNING, "Username or email already exists.");
                emailTextField.clear();
                usernameTextField.clear();
                regPassTextField.clear();
                break;
            case "DB_ERROR":
            default:
                showAlert(Alert.AlertType.ERROR, "An error occurred while registering. Please try again.");
                break;
        }
    }

    @FXML
    void registerClicked(ActionEvent event) {
        loginVBox.setVisible(false);
        loginVBox.setManaged(false);

        registerVBox.setVisible(true);
        registerVBox.setManaged(true);
    }

    public void goToLogin() {
        registerVBox.setVisible(false);
        registerVBox.setManaged(false);

        loginVBox.setVisible(true);
        loginVBox.setManaged(true);
    }

    public void loadGameStore(String username) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/a/learning/game.fxml"));
            Parent root1 = fxmlLoader.load();
            GameController gameController = fxmlLoader.getController();
            gameController.setUsername("Hello " + username + "!");

            Scene scene = new Scene(root1);

            // Apply the stylesheet manually
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

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
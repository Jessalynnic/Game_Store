package a.learning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameCardController {
    @FXML
    private ImageView gameImage;
    @FXML
    private Label gameNameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private TextField qtyTextField;

    private GameItem game;
    private GameController parentController;

    /**
     * Sets the data for the game card and updates the UI.
     */
    public void setData(GameItem game, GameController parentController) {
        this.game = game;
        this.parentController = parentController;

        // Set game name and formatted price
        gameNameLabel.setText(game.getGameName());
        priceLabel.setText(String.format("$%.2f", game.getPrice()));

        // Load image from Images folder using the image path from the GameItem
        try {
            String imagePath = "/a/learning/Images/" + game.getImagePath();
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            gameImage.setImage(image);
        } catch (Exception e) {
            System.out.println("Image not found: " + game.getImagePath());
            e.printStackTrace();
        }
    }

    @FXML
    void addButtonClicked(ActionEvent event) {
        try {
            int qty = Integer.parseInt(qtyTextField.getText());

            // Create a cart item with total price = price * quantity
            GameItem cartItem = new GameItem(game.getGameName(), qty, game.getPrice());

            // Add the item to the cart via the parent controller
            parentController.addToCart(cartItem);

            // Clear the quantity input field
            qtyTextField.clear();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid quantity.").show();
        }
    }
}

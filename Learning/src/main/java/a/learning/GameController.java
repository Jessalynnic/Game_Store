
package a.learning;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class GameController implements Initializable {
    
    @FXML
    private Button clearButton;

    @FXML
    private VBox gameListVBox;
    
    @FXML
    private TextField discountTextField;

    @FXML
    private TableView<GameItem> orderTable;
    
    @FXML
    private TableColumn<GameItem, String> gameName;
     
    @FXML
    private TableColumn<GameItem, String> qty;
    
    @FXML
    private TableColumn<GameItem, String> total;
    
    @FXML
    private Label grandTotalPriceLabel;

    @FXML
    private Label subtotalTextField;
    
    @FXML
    private Label taxPriceLabel;
    
    @FXML
    private Label userNameLabel;

    @FXML
    private Label cartBadge;

    @FXML
    private StackPane cartPane;

    
    ObservableList<GameItem> list = FXCollections.observableArrayList();
    
    
    DecimalFormat formate = new DecimalFormat("0.00");
    
    public void setUsername(String username) {
     userNameLabel.setText(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Retrieve the list of games from the database via GameDAO
        List<GameItem> games = GameDAO.getAllGames();

        // Set the number of cards per row and prepare the first HBox (row container)
        int cardsPerRow = 3;
        HBox currentRow = new HBox(20);
        currentRow.setPadding(new Insets(10));

        // Loop through the list of games and create UI cards for each one
        for (int i = 0; i < games.size(); i++) {
            GameItem game = games.get(i);
            try {
                // Load the FXML layout for a single game card
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/a/learning/GameCard.fxml"));
                VBox card = loader.load();

                // Get the controller for the game card and inject game data
                GameCardController controller = loader.getController();
                controller.setData(game, this);

                // Add the card to the current HBox (row)
                currentRow.getChildren().add(card);

                // Once the row has 3 cards or it's the last card, add the row to the VBox
                if ((i + 1) % cardsPerRow == 0 || i == games.size() - 1) {
                    gameListVBox.getChildren().add(currentRow);
                    currentRow = new HBox(20); // start a new row
                    currentRow.setPadding(new Insets(10));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        gameName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        qty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));
    }

    private void updateCartIndicator() {
        int totalQty = 0;
        for (GameItem item : list) {
            try {
                totalQty += item.getQty();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Please enter a valid whole number for quantity.");
                alert.show();
            }
        }
        cartBadge.setText(String.valueOf(totalQty));
        cartBadge.setVisible(totalQty > 0);
    }

    public void addToCart(GameItem item) {
        list.add(item);
        updateCartIndicator();
    }

     @FXML
    void cartButton(MouseEvent event) {
        orderTable.setItems(list);
    }

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        
       double totalValue=0;
       for (int i= 0;i<orderTable.getItems().size();i++){
           totalValue=totalValue+Double.valueOf(total.getCellData(i));
           }
        
        //Get the discount code from the discountTextField
        String discountCode = discountTextField.getText();
        
        //Check if the discount code is valid
        if (discountCode.equals("SANDYCLAWS")) {
            // Apply the discount to the subtotal
            totalValue *= 0.85;

            // Create an alert dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Discount Applied");
            alert.setHeaderText("A 15% discount has been applied to your total.");
        
            // Show the alert dialog
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error: Wrong Code!");
            alert.setHeaderText("Discount NOT Applied!");
            alert.show();
        }
        
        //Calculate tax
        double tax = totalValue * 0.04;
        
        //Calculate grand total
        double grandTotal = totalValue + tax;
        
	    subtotalTextField.setText("$"+formate.format(totalValue));
        taxPriceLabel.setText("$" + formate.format (tax));
        grandTotalPriceLabel.setText("$" + formate.format (grandTotal));
    }
    
    @FXML
    void clearCart(ActionEvent event) {
        // Clear the orderTable
        orderTable.setItems(null);

        // Clear the cart
        list.clear();
        updateCartIndicator();

        // Clear the subtotal, tax, and grand total labels
        subtotalTextField.setText("");
        taxPriceLabel.setText("");
        grandTotalPriceLabel.setText("");

        // Clear the discountTextField
        discountTextField.setText("");
    }
    
    
    
}

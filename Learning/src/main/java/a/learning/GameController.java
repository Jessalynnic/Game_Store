
package a.learning;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class GameController implements Initializable {

    @FXML
    private Button addToCartButton;
    
    @FXML
    private Button clearButton;
    
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
    private TextField searchTextField;
    
    @FXML
    private TextField maddenTextField;
    
    @FXML
    private TextField mirageTextField;

    @FXML
    private TextField mkTextField;

    
    @FXML
    private TextField qtyTextField;
    
    @FXML
    private TextField spiderTextField;
    
    @FXML
    private Label subtotalTextField;
    
    @FXML
    private Label taxPriceLabel;
    
    @FXML
    private TextField texasTextField;
    
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
        System.out.println(getClass().getResource("/a/learning/Images/Logo.png"));

        gameName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        qty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));
    }

    private void updateCartIndicator() {
        int totalQty = 0;
        for (GameItem item : list) {
            try {
                totalQty += Integer.parseInt(item.getQty());
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
    
    @FXML
    void addButtonClicked(ActionEvent event) {
        
        double callofdutyprice=Double.parseDouble(qtyTextField.getText())*69.99;
        list.add(new GameItem("Call of Duty: Modern Warfare III",qtyTextField.getText(), formate.format(callofdutyprice)));
        updateCartIndicator();
        qtyTextField.setText("");
        
    }
    
    @FXML
    void spiderAdd(ActionEvent event) {
        double spiderPrice=Double.parseDouble(spiderTextField.getText())*69.99;
        list.add(new GameItem("Spider-Man 2",spiderTextField.getText(), formate.format(spiderPrice)));
        updateCartIndicator();
        spiderTextField.setText("");
    }
    
    @FXML
    void mkAdd(ActionEvent event) {
        double mkPrice=Double.parseDouble(mkTextField.getText())*40.99;
        list.add(new GameItem("Mortal Kombat 1",mkTextField.getText(), formate.format(mkPrice)));
        updateCartIndicator();
        mkTextField.setText("");
    }
    
    @FXML
    void mirageAdd(ActionEvent event) {
        double miragePrice=Double.parseDouble(mirageTextField.getText())*59.99;
        list.add(new GameItem("Assassins Creed Mirage Deluxe Edition",mirageTextField.getText(), formate.format(miragePrice)));
        updateCartIndicator();
        mirageTextField.setText("");
    }
    
    @FXML
    void texasAdd(ActionEvent event) {
        double texasPrice=Double.parseDouble(texasTextField.getText())*39.49;
        list.add(new GameItem("The Texas Chain Saw Massacre",texasTextField.getText(), formate.format(texasPrice)));
        updateCartIndicator();
        texasTextField.setText("");
    }
    
    @FXML
    void maddenAdd(ActionEvent event) {
        double maddenPrice=Double.parseDouble(maddenTextField.getText())*69.99;
        list.add(new GameItem("Madden NFL 24",maddenTextField.getText(), formate.format(maddenPrice)));
        updateCartIndicator();
        maddenTextField.setText("");
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

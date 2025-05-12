
package a.learning;


public class GameItem {
    private int gameID;
    private String gameName;
    private String imagePath;
    private double price;
    private int qty;

    public GameItem(int gameID, String gameName, double price, String imagePath) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.price = price;
        this.imagePath = imagePath;
        this.qty = 0;
    }

    public GameItem(String gameName, int qty, double unitPrice) {
        this.gameName = gameName;
        this.qty = qty;
        this.price = unitPrice;
    }

    public String getGameName() {
        return gameName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return price * qty;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}



package a.learning;


public class GameItem {
    private String gameName;
    private String qty;
    private String total;

    public GameItem(String gameName, String qty, String total) {
        this.gameName = gameName;
        this.qty = qty;
        this.total = total;
    }

    public String getGameName() {
        return gameName;
    }

    public String getQty() {
        return qty;
    }

    public String getTotal() {
        return total;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    
}


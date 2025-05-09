package a.learning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves all games from the MS SQL Server database.
 */
public class GameDAO {
    public static List<GameItem> getAllGames() {
        List<GameItem> games = new ArrayList<>();
        // SQL query to select all required columns from the Games table
        String sql = "SELECT game_id, name, price, image_path FROM Games";

        try (
             // Get a connection to the database
             Connection conn = DatabaseConnection.getConnection();

             // Create a statement object to send the SQL query
             Statement stmt = conn.createStatement();

             // Execute the SQL query and get the result set as rs
             ResultSet rs = stmt.executeQuery(sql)
        ) {
            // Iterate over each row in the set
            while (rs.next()) {
                // Extract data from the current row
                int id = rs.getInt("game_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String imagePath = rs.getString("image_path");

                // Create a new GameItem object and add it to the list
                games.add(new GameItem(id, name, price, imagePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return the list of games
        return games;
    }
}

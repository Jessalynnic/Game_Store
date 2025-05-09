package a.learning;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Successfully connected to the database!");
            } else {
                System.out.println("❌ Connection failed.");
            }
        } catch (Exception e) {
            System.out.println("❌ Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

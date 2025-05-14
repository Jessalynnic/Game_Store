package a.learning;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
    public static String registerUser(String email, String username, String password) {
        String checkUser = "SELECT COUNT(*) FROM users WHERE email_address = ? OR username = ?";
        String insertSql = "INSERT INTO users (email_address, username, password_hash) VALUES (?, ?, ?)";

        try (
            // Get a connection to the database
            Connection conn = DatabaseConnection.getConnection();

            // Create a statement object to send the SQL query
            PreparedStatement checkStmt = conn.prepareStatement(checkUser);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql)
        ) {
            // Check if user already exists
            checkStmt.setString(1, email);
            checkStmt.setString(2, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return "USER_EXISTS";
            }

            String hashedPassword = DigestUtils.sha256Hex(password);

            // Insert new user
            insertStmt.setString(1, email);
            insertStmt.setString(2, username);
            insertStmt.setString(3, hashedPassword);
            insertStmt.executeUpdate();

            return "SUCCESS";

        } catch (Exception e) {
            e.printStackTrace();
            return "DB_ERROR";
        }
    }
}

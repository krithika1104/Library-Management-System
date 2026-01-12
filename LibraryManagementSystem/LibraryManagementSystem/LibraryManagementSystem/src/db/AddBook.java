package db;
import java.sql.*;
import db.DBConnection;

public class AddBook {

    public static void addBook(String title, String author) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO books(title, author, available) VALUES (?, ?, true)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);

            ps.executeUpdate();
            System.out.println("✅ Book added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

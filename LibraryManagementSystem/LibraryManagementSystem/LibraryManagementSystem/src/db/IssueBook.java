package db;
import java.sql.*;
import db.DBConnection;

public class IssueBook {

    public static void issueBook(int bookId, String issuedTo) {

        try (Connection con = DBConnection.getConnection()) {

            String check = "SELECT available FROM books WHERE book_id=?";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                if (!rs.getBoolean("available")) {
                    System.out.println("❌ Book already issued");
                    return;
                }

                String issueSql =
                        "INSERT INTO issued_books(book_id, issued_to, issue_date) " +
                        "VALUES (?, ?, CURDATE())";

                ps = con.prepareStatement(issueSql);
                ps.setInt(1, bookId);
                ps.setString(2, issuedTo);
                ps.executeUpdate();

                String update = "UPDATE books SET available=false WHERE book_id=?";
                ps = con.prepareStatement(update);
                ps.setInt(1, bookId);
                ps.executeUpdate();

                System.out.println("✅ Book issued successfully");

            } else {
                System.out.println("❌ Book ID not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

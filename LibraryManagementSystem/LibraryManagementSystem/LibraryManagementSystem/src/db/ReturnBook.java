package db;
import java.sql.*;
import db.DBConnection;

public class ReturnBook {

    public static void returnBook(int bookId) {

        try (Connection con = DBConnection.getConnection()) {

            String delete = "DELETE FROM issued_books WHERE book_id=?";
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("❌ Book was not issued");
                return;
            }

            String update = "UPDATE books SET available=true WHERE book_id=?";
            ps = con.prepareStatement(update);
            ps.setInt(1, bookId);
            ps.executeUpdate();

            System.out.println("✅ Book returned successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

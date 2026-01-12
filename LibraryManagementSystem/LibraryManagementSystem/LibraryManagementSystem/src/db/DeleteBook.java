package db;
import java.sql.*;
import db.DBConnection;

public class DeleteBook {

    public static void deleteBook(int bookId) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM books WHERE book_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Book deleted successfully");
            else
                System.out.println("❌ Book not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package db;
import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db",
                "root",
                "mahijp10"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private  static final String URL = "jdbc:mysql://localhost:3306/book_db";
    private  static  final String USER = "root";
    private  static  final  String PASSWORD = "1234";

    private static Connection getConnection() throws SQLException {
        return DriverManager. getConnection(URL, USER, PASSWORD);
    }
}

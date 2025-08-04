import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class app {
    public static void main(String[] args)
    String url = "jdbc:mysql://localhost:3306/sample";
    String user = "root";
    String password = "root";
    String sql = "CREATE TABLE IF NOT EXISTS data (" + "id INT AUTO INCREMENT PRIMARY KEY," + "name VARCHAR(100) NOT NULL," + "value VARTHAR(100)" + ")";
    try (Connection conn = DriverManager)
    Statement stmt = conn.createstatement()) {
        
    }
}
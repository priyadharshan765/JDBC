import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppRead {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample"; // Change 'your_database' to your DB name
        String user = "root"; // Change to your MySQL username
        String password = "root"; // Change to your MySQL password

        // SQL statement to select all data
        String selectSql = "SELECT id, name, value FROM data";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {

            System.out.println("ID\tName\tValue");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String value = rs.getString("value");
                System.out.println(id + "\t" + name + "\t" + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
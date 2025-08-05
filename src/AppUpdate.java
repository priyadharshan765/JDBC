import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AppUpdate {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample"; // Change 'your_database' to your DB name
        String user = "root"; // Change to your MySQL username
        String password = "root"; // Change to your MySQL password

        // SQL statement to update data
        String updateSql = "UPDATE data SET name = ?, value = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in);
             PreparedStatement pstmt = conn.prepareStatement(updateSql)) {

            System.out.print("Enter ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new value: ");
            String value = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setString(2, value);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No row found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
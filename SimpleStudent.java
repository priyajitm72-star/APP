import java.sql.*;
import java.util.Scanner;

public class SimpleStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/LibraryDB";
        String user = "root";
        String pass = "2007";

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            String insertSql = "INSERT INTO Student VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, marks);
            pstmt.executeUpdate();
            System.out.println("Record inserted!\n");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

            System.out.println("--- All Students ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") + " | Marks: " + rs.getDouble("marks"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
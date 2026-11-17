import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USER = "root";
    private static final String PASS = "2007"; // Your MySQL password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Insert Student Details");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student Marks");
                System.out.println("5. Delete Student Record");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, scanner);
                        break;
                    case 2:
                        displayStudents(conn);
                        break;
                    case 3:
                        searchStudent(conn, scanner);
                        break;
                    case 4:
                        updateMarks(conn, scanner);
                        break;
                    case 5:
                        deleteStudent(conn, scanner);
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void insertStudent(Connection conn, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO Student (StudentID, StudentName, Marks) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID: ");
            pstmt.setInt(1, scanner.nextInt());
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            pstmt.setString(2, scanner.nextLine());

            System.out.print("Enter Marks: ");
            pstmt.setDouble(3, scanner.nextDouble());

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Student inserted successfully!");
        }
    }

    private static void displayStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Student";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Student Records ---");
            boolean found = false;
            System.out.printf("%-10s %-25s %-10s%n", "ID", "Name", "Marks");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                found = true;
                System.out.printf("%-10d %-25s %-10.2f%n",
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getDouble("Marks"));
            }

            if (!found) System.out.println("No student records found.");
        }
    }

    private static void searchStudent(Connection conn, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID to search: ");
            pstmt.setInt(1, scanner.nextInt());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n--- Student Found ---");
                    System.out.println("ID: " + rs.getInt("StudentID"));
                    System.out.println("Name: " + rs.getString("StudentName"));
                    System.out.println("Marks: " + rs.getDouble("Marks"));
                } else {
                    System.out.println("Student ID not found.");
                }
            }
        }
    }

    private static void updateMarks(Connection conn, Scanner scanner) throws SQLException {
        String sql = "UPDATE Student SET Marks = ? WHERE StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID to update marks: ");
            int id = scanner.nextInt();

            System.out.print("Enter New Marks: ");
            double marks = scanner.nextDouble();

            pstmt.setDouble(1, marks);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Marks updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }

    private static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }
}
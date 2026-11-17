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
import java.sql.*;
import java.util.Scanner;

public class CourseQuerySystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CollegeDB";
    private static final String USER = "root";
    private static final String PASS = "2007";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Course Code (e.g., CSE201): ");
        String courseCode = scanner.nextLine().trim();

        String query = "SELECT StudentID, StudentName, CourseName, Semester " +
                       "FROM CourseRegistration WHERE CourseCode = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, courseCode);

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean hasRows = false;

                while (rs.next()) {
                    if (!hasRows) {
                        System.out.println("\n--- Students Registered for " + courseCode + " ---");
                        System.out.printf("%-12s %-20s %-25s %-10s%n", "StudentID", "StudentName", "CourseName", "Semester");
                        System.out.println("----------------------------------------------------------------------");
                        hasRows = true;
                    }

                    System.out.printf("%-12d %-20s %-25s %-10d%n",
                            rs.getInt("StudentID"),
                            rs.getString("StudentName"),
                            rs.getString("CourseName"),
                            rs.getInt("Semester"));
                }

                if (!hasRows) {
                    System.out.println("\nNo students are registered for the course code: " + courseCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
import java.sql.*;
import java.util.Scanner;

public class LibraryManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String USER = "root";
    private static final String PASS = "2007";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            while (true) {
                System.out.println("\n--- Library System Menu ---");
                System.out.println("1. Insert New Book");
                System.out.println("2. Search Book by ID");
                System.out.println("3. Display All Available Books");
                System.out.println("4. Change Availability Status (Issue/Return)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        String insertSql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                            System.out.print("Enter Book ID: ");
                            pstmt.setInt(1, scanner.nextInt());
                            scanner.nextLine();

                            System.out.print("Enter Title: ");
                            pstmt.setString(2, scanner.nextLine());

                            System.out.print("Enter Author: ");
                            pstmt.setString(3, scanner.nextLine());

                            System.out.print("Enter Price: ");
                            pstmt.setDouble(4, scanner.nextDouble());

                            System.out.print("Is Available (true/false): ");
                            pstmt.setBoolean(5, scanner.nextBoolean());

                            pstmt.executeUpdate();
                            System.out.println("Book inserted successfully!");
                        }
                        break;

                    case 2:
                        String searchSql = "SELECT * FROM Book WHERE BookID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(searchSql)) {
                            System.out.print("Enter Book ID to search: ");
                            pstmt.setInt(1, scanner.nextInt());

                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                    System.out.println("\n--- Book Details ---");
                                    System.out.println("Book ID: " + rs.getInt("BookID"));
                                    System.out.println("Title: " + rs.getString("Title"));
                                    System.out.println("Author: " + rs.getString("Author"));
                                    System.out.println("Price: " + rs.getDouble("Price"));
                                    System.out.println("Available: " + (rs.getBoolean("Availability") ? "Yes" : "No"));
                                } else {
                                    System.out.println("No book found with that ID.");
                                }
                            }
                        }
                        break;

                    case 3:
                        String displaySql = "SELECT * FROM Book WHERE Availability = TRUE";
                        try (Statement stmt = conn.createStatement();
                             ResultSet rs = stmt.executeQuery(displaySql)) {

                            System.out.println("\n--- Available Books ---");
                            boolean found = false;
                            while (rs.next()) {
                                found = true;
                                System.out.printf("ID: %d | Title: %s | Author: %s | Price: %.2f%n",
                                        rs.getInt("BookID"),
                                        rs.getString("Title"),
                                        rs.getString("Author"),
                                        rs.getDouble("Price"));
                            }
                            if (!found) {
                                System.out.println("No books are currently available.");
                            }
                        }
                        break;

                    case 4:
                        String updateSql = "UPDATE Book SET Availability = ? WHERE BookID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                            System.out.print("Enter Book ID to update: ");
                            int id = scanner.nextInt();

                            System.out.print("Enter new Availability (true for available, false for issued): ");
                            boolean status = scanner.nextBoolean();

                            pstmt.setBoolean(1, status);
                            pstmt.setInt(2, id);

                            int rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Availability updated successfully!");
                            } else {
                                System.out.println("No book found with ID: " + id);
                            }
                        }
                        break;

                    case 5:
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
}
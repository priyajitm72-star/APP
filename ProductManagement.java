import java.sql.*;
import java.util.Scanner;

public class ProductManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/StoreDB";
    private static final String USER = "root";
    private static final String PASS = "2007";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            while (true) {
                System.out.println("\n--- Store Inventory Menu ---");
                System.out.println("1. Insert New Product");
                System.out.println("2. Retrieve Product by ID");
                System.out.println("3. Update Product Quantity");
                System.out.println("4. Display Products with Quantity < 10");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        String insertSql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                            System.out.print("Enter Product ID: ");
                            pstmt.setInt(1, scanner.nextInt());
                            scanner.nextLine();

                            System.out.print("Enter Product Name: ");
                            pstmt.setString(2, scanner.nextLine());

                            System.out.print("Enter Price: ");
                            pstmt.setDouble(3, scanner.nextDouble());

                            System.out.print("Enter Quantity: ");
                            pstmt.setInt(4, scanner.nextInt());

                            pstmt.executeUpdate();
                            System.out.println("Product added successfully!");
                        }
                        break;

                    case 2:
                        String searchSql = "SELECT * FROM Product WHERE ProductID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(searchSql)) {
                            System.out.print("Enter Product ID to retrieve: ");
                            pstmt.setInt(1, scanner.nextInt());

                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                    System.out.println("\n--- Product Details ---");
                                    System.out.println("ID: " + rs.getInt("ProductID"));
                                    System.out.println("Name: " + rs.getString("ProductName"));
                                    System.out.println("Price: " + rs.getDouble("Price"));
                                    System.out.println("Quantity: " + rs.getInt("Quantity"));
                                } else {
                                    System.out.println("Product not found.");
                                }
                            }
                        }
                        break;

                    case 3:
                        String updateSql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                            System.out.print("Enter Product ID: ");
                            int id = scanner.nextInt();

                            System.out.print("Enter New Quantity: ");
                            int qty = scanner.nextInt();

                            pstmt.setInt(1, qty);
                            pstmt.setInt(2, id);

                            int rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Quantity updated successfully!");
                            } else {
                                System.out.println("Product ID not found.");
                            }
                        }
                        break;

                    case 4:
                        String lowStockSql = "SELECT * FROM Product WHERE Quantity < 10";
                        try (PreparedStatement pstmt = conn.prepareStatement(lowStockSql);
                             ResultSet rs = pstmt.executeQuery()) {

                            System.out.println("\n--- Low Stock Products (Quantity < 10) ---");
                            boolean found = false;
                            while (rs.next()) {
                                found = true;
                                System.out.printf("ID: %d | Name: %s | Price: %.2f | Quantity: %d%n",
                                        rs.getInt("ProductID"),
                                        rs.getString("ProductName"),
                                        rs.getDouble("Price"),
                                        rs.getInt("Quantity"));
                            }
                            if (!found) {
                                System.out.println("No products have low stock.");
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
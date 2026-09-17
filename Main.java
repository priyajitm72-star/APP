import java.util.Scanner;

abstract class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    abstract void displayDetails();
}

class Customer extends User {
    int foodItems;
    double foodCost;

    Customer(int userId, String name, int foodItems) {
        super(userId, name);
        this.foodItems = foodItems;
    }

    void calculateFoodCost(Scanner sc) {
        foodCost = 0;
        for (int i = 1; i <= foodItems; i++) {
            foodCost += sc.nextDouble();
        }
    }

    @Override
    void displayDetails() {
        System.out.println("Customer: " + userId + " " + name);
    }
}

class DeliveryPartner extends User {
    DeliveryPartner(int userId, String name) {
        super(userId, name);
    }

    @Override
    void displayDetails() {
        System.out.println("Delivery Partner: " + userId + " " + name);
    }
}

class Restaurant extends User {
    Restaurant(int userId, String name) {
        super(userId, name);
    }

    @Override
    void displayDetails() {
        System.out.println("Restaurant: " + userId + " " + name);
    }
}

class FoodOrder {
    double foodCost;
    double distance;

    FoodOrder(double foodCost, double distance) {
        this.foodCost = foodCost;
        this.distance = distance;
    }

    double deliveryCharge() {
        if (distance <= 5) {
            return 30;
        } else {
            return 30 +(distance - 5) * 10;
        }
    }

    double tax() {
        return foodCost * 0.05;
    }

    double finalAmount() {
        return foodCost + deliveryCharge() + tax();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        String name = sc.next();
        int items = sc.nextInt();

        Customer customer = new Customer(id, name, items);
        customer.calculateFoodCost(sc);

        double distance = sc.nextDouble();

        FoodOrder order = new FoodOrder(customer.foodCost, distance);

        customer.displayDetails();
        System.out.println("Food Items: " + items);
        System.out.println("Food Cost: " + (int) order.foodCost);
        System.out.println("Delivery Charge: " + (int) order.deliveryCharge());
        System.out.println("Tax: " + (int) order.tax());
        System.out.println("Final Amount: " + (int) order.finalAmount());

        sc.close();
    }
}
import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class graphic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");

        int choice = sc.nextInt();

        Shape shape;

        if (choice == 1) {
            System.out.print("Enter radius: ");
            shape = new Circle(sc.nextDouble());
        } else if (choice == 2) {
            System.out.print("Enter length and width: ");
            shape = new Rectangle(sc.nextDouble(), sc.nextDouble());
        } else {
            System.out.print("Enter base and height: ");
            shape = new Triangle(sc.nextDouble(), sc.nextDouble());
        }

        System.out.println("Area: " + shape.calculateArea());
    }
}
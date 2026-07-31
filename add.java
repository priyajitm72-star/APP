import java.util.Scanner;

public class add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, sum;
        System.out.print("Enter the 1st value:");
        num1 = sc.nextInt();
        System.out.print("Enter the 2nd no:");
        num2 = sc.nextInt();
        sum = num1 + num2;
        System.out.print("total=" + sum);
        sc.close();
    }

}
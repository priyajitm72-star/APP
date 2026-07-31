import java.util.Scanner;

public class largest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3, largest;
        System.out.print("Enter the 1st number=");
        num1 = sc.nextInt();
        System.out.print("Enter the 2nd number=");
        num2 = sc.nextInt();
        System.out.print("Enter the 3rd number=");
        num3 = sc.nextInt();
        if (num1 > num2) {
            largest = num1;
        } else if (num2 > num3) {
            largest = num2;
        } else {
            largest = num3;
        }
        System.out.print("largest=" + largest);
        sc.close();
    }
}
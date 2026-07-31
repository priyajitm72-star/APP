import java.util.Scanner;
public class odd {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num1;
        System.out.print("Enter the number=");
        num1 = sc.nextInt();
        if(num1%2==0){
            System.out.print("The no. is even");
        }
        else{
            System.out.print("The no. is odd");
        }
        sc.close();
    }
}

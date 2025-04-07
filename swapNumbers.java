import java.util.Scanner;

public class swapNumbers {
    

    public static void main(String arr[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a :");
        int a = scanner.nextInt();
        System.out.println("Enter b : ");
        int b = scanner.nextInt();

        swap(a , b); // 6,4
    }

    public static void swap(int a , int b){

        a = a +b;  //10
        b= a -b;   // 10 -4 = 6
        a = a -b;

        System.out.println("swapNumaber : a=" +a +" , "+"b = "+b);
    }
}

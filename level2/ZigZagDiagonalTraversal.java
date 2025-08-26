package level2;

import java.util.*;

public class ZigZagDiagonalTraversal {

    public static void main(String arr[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns:");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = new int[row-1][col-1];

        System.out.println("enter matrix value");

        for(int i=0; i < row-1 ; i++){
            for(int j=0 ; j < col-1 ; j++){
                matrix[row][col] = scanner.nextInt();

            }
        }

        for(int i=0; i < row-1 ; i++){
            for(int j=0 ; j < col-1 ; j++){
                System.out.println(matrix[row][col]);

            }
        }








    }
}

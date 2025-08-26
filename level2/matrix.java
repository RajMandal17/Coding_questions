package level2;

import java.util.Scanner;

public class matrix {

    public static void main(String[] arr){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row");
        int row = sc.nextInt();
        System.out.println("Enter Column");
        int col = sc.nextInt();
        System.out.println("Enter Elements");
        int[][] matrix = new int[row][col];

        for(int i=0; i<matrix[0].length ; i++){
            for(int j=0; j<matrix[1].length ; j++){
                matrix[i][j]= sc.nextInt();
            }
        }



        for(int i=0 ; i<matrix[0].length ; i++){
            for(int j=0 ; j<matrix[1].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

    }
}

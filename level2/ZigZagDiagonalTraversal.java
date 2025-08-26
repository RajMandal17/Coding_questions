package level2;

import java.util.*;

public class ZigZagDiagonalTraversal {

    public static void main(String arr[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Zigzag diagonal traversal:");
        zigzagDiagonalTraversal(matrix);

    }

    public static void zigzagDiagonalTraversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        for (int d = 0; d < n + m - 1; d++) {
            int rowStart = Math.max(0, d - m + 1);
            int rowEnd = Math.min(n - 1, d);
            List<Integer> temp = new ArrayList<>();
            if (d % 2 == 0) {
                // Even diagonal: bottom-left to top-right
                for (int row = rowEnd; row >= rowStart; row--) {
                    int col = d - row;
                    if (col >= 0 && col < m) {
                        temp.add(matrix[row][col]);
                    }
                }
                for (int num : temp) {
                    System.out.print(num + " ");
                }
            } else {
                // Odd diagonal: top-right to bottom-left
                for (int row = rowStart; row <= rowEnd; row++) {
                    int col = d - row;
                    if (col >= 0 && col < m) {
                        temp.add(matrix[row][col]);
                    }
                }
                for (int i = temp.size() - 1; i >= 0; i--) {
                    System.out.print(temp.get(i) + " ");
                }
            }
        } 
    }
}

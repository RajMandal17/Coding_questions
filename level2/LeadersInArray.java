package level2;

import java.util.*;

public class LeadersInArray {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] str = scanner.nextLine().split(" ");
      int[] arr = new int[str.length];

      for (int i = 0; i < str.length; i++) {
          arr[i] = Integer.parseInt(str[i]);    

      }

      printLeaders(arr);


    }

    public static void printLeaders(int[] arr) {
        // A leader is an element which is greater than or equal to all elements to its right.
        // For example, in arr[] = {16, 17, 4, 3, 5, 2}, leaders are 17, 5, 2.
        // 2 is a leader (no elements to its right), 5 is greater than 2, 17 is greater than 4, 3, 5, 2.
        // The function prints all such leaders in the array.
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n - 1]; // Start with the last element as a leader
        leaders.add(maxFromRight);
        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight); // Add new leader
            }
        }
        // Leaders are collected in reverse order, so reverse the list
        Collections.reverse(leaders);
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
        System.out.println();
    }
}

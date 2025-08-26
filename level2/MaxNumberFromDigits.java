import java.util.*;

public class MaxNumberFromDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter single-digit numbers separated by space:");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println("Maximum Number Formed: " + formMaxNumber(nums));
    }

    public static String formMaxNumber(int[] nums) {
        // QUESTION:
        // Given an array of single-digit integers, arrange them to form the maximum possible number.
        // Example: nums = {8, 7, 9, 1} => Maximum Number Formed: 9871
        // 
        // SOLUTION:
        // 1. Convert the int[] to Integer[] so we can use custom sorting.
        // 2. Sort the array in descending order (largest digit first).
        // 3. Concatenate the sorted digits to form the largest possible number.
        // 4. Return the result as a string.
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }
}

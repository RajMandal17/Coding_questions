package Array_java;

import java.util.*;

/**
 * LeetCode: Majority Element
 *
 * Given an array nums of size n, return the majority element.
 * The majority element appears more than floor(n/2) times. You may assume it always exists.
 *
 * This file provides several approaches and explanations:
 * 1) Boyer-Moore Voting Algorithm (O(n) time, O(1) space) - preferred for follow-up requirement.
 * 2) HashMap counting (O(n) time, O(n) space) - straightforward.
 * 3) Sorting (O(n log n) time, O(1) space if sort in-place) - the middle element is the majority.
 * 4) Divide and Conquer (O(n log n) time) - recursive approach.
 * 5) Bit count (O(n) time, O(1) space) - reconstruct the majority bit by bit.
 * 6) Randomized (expected O(n)) - useful as demonstration only.
 *
 * We'll demonstrate each with sample inputs.
 */
public class MajorityElement {

    // 1) Boyer-Moore Voting Algorithm
    public static int majorityElementBoyerMoore(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate; // guaranteed to be majority per problem statement
    }

    // 2) HashMap counting
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int threshold = nums.length / 2;
        for (int num : nums) {
            int c = freq.getOrDefault(num, 0) + 1;
            if (c > threshold) return num;
            freq.put(num, c);
        }
        return nums[0];
    }

    // 3) Sorting approach
    public static int majorityElementSorting(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        return copy[copy.length / 2];
    }

    // 4) Divide and Conquer
    public static int majorityElementDivideConquer(int[] nums) {
        return majorityRec(nums, 0, nums.length - 1);
    }

    private static int majorityRec(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftMajor = majorityRec(nums, left, mid);
        int rightMajor = majorityRec(nums, mid + 1, right);
        if (leftMajor == rightMajor) return leftMajor;
        int leftCount = countInRange(nums, leftMajor, left, right);
        int rightCount = countInRange(nums, rightMajor, left, right);
        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    private static int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) if (nums[i] == num) count++;
        return count;
    }

    // 5) Bit count method
    public static int majorityElementBitCount(int[] nums) {
        int majority = 0;
        int n = nums.length;
        for (int bit = 0; bit < 32; bit++) {
            int bitCount = 0;
            for (int num : nums) {
                if (((num >> bit) & 1) == 1) bitCount++;
            }
            if (bitCount > n / 2) majority |= (1 << bit);
        }
        return majority;
    }

    // 6) Randomized approach (expected linear) - pick random index and check
    public static int majorityElementRandomized(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        while (true) {
            int candidate = nums[rand.nextInt(n)];
            int count = 0;
            for (int num : nums) if (num == candidate) count++;
            if (count > n / 2) return candidate;
        }
    }

    // Example runner and quick verification
    public static void main(String[] args) {
        int[] ex1 = {3, 2, 3};
        int[] ex2 = {2,2,1,1,1,2,2};

        System.out.println("Example 1: " + Arrays.toString(ex1));
        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(ex1));
        System.out.println("HashMap:      " + majorityElementHashMap(ex1));
        System.out.println("Sorting:      " + majorityElementSorting(ex1));
        System.out.println("DivideConq:   " + majorityElementDivideConquer(ex1));
        System.out.println("BitCount:     " + majorityElementBitCount(ex1));
        System.out.println("Randomized:   " + majorityElementRandomized(ex1));
        System.out.println();

        System.out.println("Example 2: " + Arrays.toString(ex2));
        System.out.println("Boyer-Moore: " + majorityElementBoyerMoore(ex2));
        System.out.println("HashMap:      " + majorityElementHashMap(ex2));
        System.out.println("Sorting:      " + majorityElementSorting(ex2));
        System.out.println("DivideConq:   " + majorityElementDivideConquer(ex2));
        System.out.println("BitCount:     " + majorityElementBitCount(ex2));
        System.out.println("Randomized:   " + majorityElementRandomized(ex2));
    }
}

package Array_java;

import java.util.*;

/**
 * Problem: Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appears only once and returns the new length. Do not allocate extra
 * space for another array; you must do this by modifying the input array in-place
 * with O(1) extra memory.
 *
 * Example:
 * Input:  nums = [1,1,2]
 * Output: length = 2, nums = [1,2,_]
 *
 * Approach (Sorted array - two pointers):
 * - Use two pointers: 'write' points to the position to write the next unique
 *   element (start at 1), and 'read' scans from 1..n-1.
 * - If nums[read] != nums[read-1], write nums[read] to nums[write] and
 *   increment write.
 * - At the end, 'write' is the new length (number of unique elements).
 *
 * Time: O(n), Space: O(1)
 */
public class RemoveDuplicates {

    // Sorted array solution
    public static int removeDuplicatesSorted(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        int write = 1; // index to write the next unique element
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    // If array is NOT sorted: use a LinkedHashSet to preserve order (extra space O(n))
    public static int removeDuplicatesUnsorted(int[] nums) {
        if (nums == null) return 0;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int x : nums) set.add(x);
        int i = 0;
        for (int v : set) nums[i++] = v;
        return set.size();
    }

    // In-place for unsorted without extra space is possible but O(n^2):
    // for each element, check if it appeared before (shift array when duplicate found).
    public static int removeDuplicatesUnsortedInPlaceQuadratic(int[] nums) {
        if (nums == null) return 0;

        int n = nums.length;
        int write = 0;
        for (int i = 0; i < n; i++) {
            boolean seen = false;
            for (int j = 0; j < write; j++) {
                if (nums[j] == nums[i]) { seen = true; break; }
            }
            if (!seen) {
                nums[write] = nums[i];
                write = write + 1;
            }
        }
        return write;
    }

    // Helper to print array state
    private static void printResult(int[] nums, int len) {
        System.out.print("Length = " + len + ", nums = [");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            if (i + 1 < len) System.out.print(",");
        }
        System.out.println("]");
    }

    // Related questions (with brief answers):
    // 1) If array is not sorted, what's the best approach? Use a HashSet/LinkedHashSet
    //    to remove duplicates in O(n) time but O(n) extra space. If you must be in-place,
    //    you can do the O(n^2) in-place method.
    // 2) How to remove duplicates but keep only elements that occur once? Use a frequency map
    //    (HashMap) to count then write elements with count==1.
    // 3) How to remove duplicates but maintain original order? Use LinkedHashSet (preserves
    //    insertion order) or stable filtering using HashMap + write pointer.
    // 4) How to remove duplicates from a sorted linked list? Traverse and remove consecutive
    //    equal nodes by adjusting pointers (similar to two-pointer idea).
    // 5) How to return the array of removed duplicate elements? Collect duplicates into a list
    //    while scanning and return that list (requires extra space).

    // Example runner
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2};
        System.out.print("Sorted example: ");
        int newLen1 = removeDuplicatesSorted(a1);
        printResult(a1, newLen1); // expected [1,2]

        int[] a2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.print("Sorted example 2: ");
        int newLen2 = removeDuplicatesSorted(a2);
        printResult(a2, newLen2); // expected [0,1,2,3,4]

        int[] b1 = {3,1,2,3,2,1};
        System.out.print("Unsorted example (LinkedHashSet): ");
        int newLen3 = removeDuplicatesUnsorted(b1);
        printResult(b1, newLen3); // expected [3,1,2]

        int[] b2 = {3,1,2,3,2,1};
        System.out.print("Unsorted in-place O(n^2): ");
        int newLen4 = removeDuplicatesUnsortedInPlaceQuadratic(b2);
        printResult(b2, newLen4); // expected [3,1,2]
    }
}

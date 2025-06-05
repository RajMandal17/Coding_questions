public class JumpGame {

    /**
     * Determines if you can reach the last index of the array by jumping.
     * @param nums Array where each element represents the maximum jump length at that position
     * @return true if the last index is reachable, false otherwise
     */
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // Tracks the farthest index we can currently reach

        // Iterate through each position in the array
        for (int i = 0; i < nums.length; i++) {
            // If current index exceeds maxReach, we can't proceed further
            if (i > maxReach) {
                return false;
            }

            // Update maxReach to be the maximum of:
            // - Current maxReach
            // - The farthest we can jump from current position (i + nums[i])
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach or surpass the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // If we've processed all elements without returning false, we can reach the end
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Can reach the end with jumps 0→1→4
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1: " + canJump(nums1)); // Expected: true

        // Test Case 2: Gets stuck at index 3 (value 0)
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test Case 2: " + canJump(nums2)); // Expected: false

        // Test Case 3: Single element (already at last index)
        int[] nums3 = {0};
        System.out.println("Test Case 3: " + canJump(nums3)); // Expected: true

        // Test Case 4: Large initial jump covers entire array
        int[] nums4 = {5, 0, 0, 0, 0, 0, 0};
        System.out.println("Test Case 4: " + canJump(nums4)); // Expected: true

        // Test Case 5: Cannot cross the 0 at index 2
        int[] nums5 = {1, 1, 0, 1, 1};
        System.out.println("Test Case 5: " + canJump(nums5)); // Expected: false
    }
}
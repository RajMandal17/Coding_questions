package Array_java;

import java.util.Arrays;

/**
 * LeetCode 283. Move Zeroes
 *
 * Problem:
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements. Do this in-place without making
 * a copy of the array.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 * Approach (Swap-based two-pointer):
 * - Use two pointers: 'nz' (read pointer) scans the array and 'z' points to
 *   the position of the next zero that should be swapped with a non-zero.
 * - When nums[nz] is non-zero, swap nums[nz] and nums[z], then increment both
 *   pointers. If nums[nz] is zero, only increment nz.
 * - This keeps non-zero elements in relative order, moves zeros to the end,
 *   and performs swaps in-place without extra memory.
 *
 * Benefits:
 * - Time complexity: O(n)
 * - Space complexity: O(1) (fully in-place)
 * - When zeros are rare, this approach performs fewer writes than the
 *   overwrite-then-fill method because it swaps only when needed.
 *
 * Example trace (nums = [0,1,0,3,12]):
 * - Initial: nums = [0,1,0,3,12], nz=0, z=0
 * - nz=0 -> nums[0]==0 -> nz++ (nz=1)
 * - nz=1 -> nums[1]==1 !=0 -> swap nums[1] and nums[0]
 *   nums becomes [1,0,0,3,12], nz=2, z=1
 * - nz=2 -> nums[2]==0 -> nz++ (nz=3)
 * - nz=3 -> nums[3]==3 !=0 -> swap nums[3] and nums[1]
 *   nums becomes [1,3,0,0,12], nz=4, z=2
 * - nz=4 -> nums[4]==12 !=0 -> swap nums[4] and nums[2]
 *   nums becomes [1,3,12,0,0], nz=5, z=3
 * - Done. Final: [1,3,12,0,0]
 */
public class MoveZeroes {

	// In-place solution
	public static void moveZeroes(int[] nums) {

		if (nums == null || nums.length <= 1) return;

		int z = 0, nz = 0; // z = position to place next non-zero, nz = scanning pointer
		while (nz < nums.length) {
			if (nums[nz] != 0) {
				int temp = nums[nz];
				nums[nz] = nums[z];
				nums[z] = temp;
				nz++;
				z++;
			} else {
				// advance the read pointer when current is zero
				nz++;
			}
		}





	}

	// Helper to print arrays for demonstration
	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	// Example runner with provided test cases
	public static void main(String[] args) {
		int[] nums1 = {0, 1, 0, 3, 12};
		System.out.print("Input:  "); printArray(nums1);
		moveZeroes(nums1);
		System.out.print("Output: "); printArray(nums1); // expected [1,3,12,0,0]

		int[] nums2 = {0};
		System.out.print("Input:  "); printArray(nums2);
		moveZeroes(nums2);
		System.out.print("Output: "); printArray(nums2); // expected [0]
	}
}

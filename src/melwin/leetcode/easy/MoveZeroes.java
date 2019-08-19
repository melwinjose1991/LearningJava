package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Two Pointer

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int write_index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[write_index++] = nums[i];
		}
		while (write_index < nums.length)
			nums[write_index++] = 0;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 1, 2, 3 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 0, 0, 0 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] { 0 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] { 1 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}

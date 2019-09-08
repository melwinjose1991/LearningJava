package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays 

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		int[] tmp = new int[k];
		for (int i = nums.length - k; i < nums.length; i++) {
			int j = i - nums.length + k;
			tmp[j] = nums[i];
		}
		for (int i = nums.length - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = tmp[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { -1, -100, 3, 99 };
		rotate(nums, 2);
		System.out.println(Arrays.toString(nums));
	}

}

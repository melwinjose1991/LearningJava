package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays

public class TwoSum {

	// Time : O(N^2)
	// Space : O(1)
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}

		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(a, 9)));
	}

}

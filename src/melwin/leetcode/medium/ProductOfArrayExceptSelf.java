package melwin.leetcode.medium;

import java.util.Arrays;

// Arrays | Pre Processing

public class ProductOfArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		int prod_right = 1;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[i] = 1;
			} else if (i == 1) {
				result[i] = nums[i - 1];
			} else {
				result[i] = result[i - 1] * nums[i - 1];
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				continue;
			} else if (i == nums.length - 2) {
				result[i] = result[i] * nums[i + 1];
				prod_right = nums[i + 1];
			} else {
				result[i] = result[i] * nums[i + 1] * prod_right;
				prod_right = prod_right * nums[i + 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

}

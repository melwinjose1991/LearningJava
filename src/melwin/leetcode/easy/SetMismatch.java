package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Easy

public class SetMismatch {
	public static int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int duplicated = -1, missing = -1;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] == nums[i]) {
				duplicated = nums[i];
			}
		}

		for (int i = 0, j = 1; i < n; i++) {
			if (i >= 1 && nums[i - 1] == nums[i]) {
			} else if (nums[i] != j) {
				missing = j;
				break;
			} else {
				j++;
			}
		}
		if (missing == -1)
			missing = n;
		return new int[] { duplicated, missing };
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 4 };
		System.out.println(Arrays.toString(findErrorNums(nums)));

		nums = new int[] { 1, 2, 3, 2 };
		System.out.println(Arrays.toString(findErrorNums(nums)));
	}

}

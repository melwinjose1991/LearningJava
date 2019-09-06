package melwin.leetcode.medium;

import java.util.Arrays;

// Arrays | Marker

public class FindTheDuplicateNumber {
	public static int findDuplicate(int[] nums) {
		int duplicate = 0;
		for (int i = 0; i < nums.length; i++) {
			int index = (nums[i] < 0 ? -nums[i] : nums[i]) - 1;
			if (nums[index] < 0) {
				duplicate = nums[i] < 0 ? -nums[i] : nums[i];
			} else {
				nums[index] = nums[index] * -1;
			}
		}
		// System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * (nums[i] < 0 ? -1 : 1);
		}
		// System.out.println(Arrays.toString(nums));

		return duplicate;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));

		nums = new int[] { 3, 1, 3, 4, 2 };
		System.out.println(findDuplicate(nums));
	}

}

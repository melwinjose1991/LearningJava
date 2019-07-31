package melwin.leetcode.medium;

import java.util.HashMap;

// Arrays | Hash Map

public class ContiguousArray {
	public static int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, max_len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum--;
			} else {
				sum++;
			}
			if (sum == 0) {
				max_len = Math.max(max_len, i + 1);
			} else {
				if (map.containsKey(sum)) {
					max_len = Math.max(max_len, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 1 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 0, 0, 1, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 1 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 1, 0, 1, 0 };
		System.out.println(findMaxLength(nums));
	}

}

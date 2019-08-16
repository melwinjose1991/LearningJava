package melwin.leetcode.medium;

import java.util.HashMap;

// DP | HashMap Storage

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		HashMap<Integer, Integer> num_len = new HashMap<>();
		int max_len = 0;
		for (int num : nums) {
			num_len.put(num, num_len.getOrDefault(num, 1));
			for (int key : num_len.keySet()) {
				if (key < num) {
					int cur_max = Math.max(num_len.get(key) + 1, num_len.get(num));
					num_len.put(num, cur_max);
				}
			}
			max_len = Math.max(num_len.get(num), max_len);
		}
		return max_len;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

}

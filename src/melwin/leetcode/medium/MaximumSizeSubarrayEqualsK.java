package melwin.leetcode.medium;

import java.util.HashMap;

// LEETCODE - 325 - Maximum Size Subarray Equals K - O(n)
// HashMap - stores cumulative <sum,index>
// Dynamic Programming

public class MaximumSizeSubarrayEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {

		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			if (sum == k) {
				// firs time max is set
				max = i + 1;
			} else if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}

			if (!map.containsKey(sum))
				map.put(sum, i);
		}

		return max;
	}

	public static void main(String[] args) {
	}

}

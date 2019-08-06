package melwin.leetcode.medium;

import java.util.HashMap;

// HashMap

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> sum_count = new HashMap<>();
		int cur_sum = 0;
		int count = 0;
		for (int n : nums) {
			cur_sum += n;
			if (cur_sum == k) {
				count++;
			}
			count += sum_count.getOrDefault(cur_sum - k, 0);
			sum_count.put(cur_sum, sum_count.getOrDefault(cur_sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

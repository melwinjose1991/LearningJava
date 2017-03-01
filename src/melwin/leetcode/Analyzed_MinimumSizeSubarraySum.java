package melwin.leetcode;

// ||ARRAY|| ||SUBARRAY|| ||O(n)||
// ||DOUBLE POINTER||

public class Analyzed_MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int curr_sum = 0, min_len = n + 1;
		int start = 0, end = 0;

		while (end < n) {
			while (curr_sum < s && end < n)
				curr_sum += nums[end++];

			while (curr_sum >= s && start < n) {
				if (end - start < min_len)
					min_len = end - start;
				curr_sum -= nums[start++];
			}
		}
		if (min_len == n + 1)
			return 0;
		else
			return min_len;
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 4 };
		int sum = 4;
		Analyzed_MinimumSizeSubarraySum x = new Analyzed_MinimumSizeSubarraySum();
		System.out.println(x.minSubArrayLen(sum, array));
	}

}

package melwin.leetcode.easy;

// Array | Sliding Window

public class MaxAverageSubArrayI {
	public static double findMaxAverage(int[] nums, int k) {
		int max_sum = Integer.MIN_VALUE;
		int cur_sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i <= k - 1) {
				cur_sum += nums[i];
				if (i == k - 1)
					max_sum = cur_sum;
			} else {
				cur_sum += nums[i];
				cur_sum -= nums[i - k];
				if (cur_sum > max_sum) {
					max_sum = cur_sum;
				}
			}
		}
		return (double) max_sum / k;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 0, 4, 3, 3 };
		System.out.println(findMaxAverage(nums, 5));
	}

}

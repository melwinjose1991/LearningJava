package melwin.leetcode.easy;

public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int sum = 0;
		int max_sum = Integer.MIN_VALUE;
		for (int n : nums) {
			if (n + sum > n)
				sum = sum + n;
			else
				sum = n;
			max_sum = Math.max(max_sum, sum);
		}
		return max_sum;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

}

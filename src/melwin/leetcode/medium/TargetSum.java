package melwin.leetcode.medium;

// 494 - Target Sum - solve the equation

public class TargetSum {

	// sum(P) -sum(N) = target (adding sum(P)+sum(N) on both sides and solve for
	// sum(p))
	
	// sum(P) = (target+sum)/2

	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}

	public int subsetSum(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int no : nums)
			for (int i = target; i >= no; i--)
				dp[i] += dp[i - no];

		return dp[target];
	}

	public static void main(String[] args) {
	}

}

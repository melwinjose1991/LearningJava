package melwin.leetcode.medium;

public class TargetSum {

	private static int count;

	public static int findTargetSumWays(int[] nums, int S) {
		count = 0;
		dfs(nums, 0, 0, S);
		return count;
	}

	private static void dfs(int[] nums, int i, int sum, int reqd_sum) {
		if (i == nums.length) {
			if (sum == reqd_sum) {
				count++;
			}
		} else {
			dfs(nums, i + 1, sum + nums[i], reqd_sum);
			dfs(nums, i + 1, sum - nums[i], reqd_sum);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		System.out.println(findTargetSumWays(nums, 3));
	}

}

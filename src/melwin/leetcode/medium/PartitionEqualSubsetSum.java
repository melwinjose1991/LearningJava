package melwin.leetcode.medium;

// Arrays | DFS 

public class PartitionEqualSubsetSum {
	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % 2 == 0 && isSum(nums, 0, 0, sum / 2)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isSum(int[] nums, int i, int sum, int sum_reqd) {
		if (i == nums.length || sum > sum_reqd)
			return false;
		if (sum == sum_reqd)
			return true;

		if (isSum(nums, i + 1, sum + nums[i], sum_reqd) || isSum(nums, i + 1, sum, sum_reqd))
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };
		System.out.println(canPartition(nums));

		nums = new int[] { 1, 2, 3, 5 };
		System.out.println(canPartition(nums));
	}

}

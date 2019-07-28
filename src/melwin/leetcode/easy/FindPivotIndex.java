package melwin.leetcode.easy;

// Arrays | Preprocessing

public class FindPivotIndex {
	public static int pivotIndex(int[] nums) {
		int[] back_sum = new int[nums.length];
		int[] forward_sum = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				back_sum[i] = 0;
			else
				back_sum[i] = back_sum[i - 1] + nums[i - 1];

			int j = nums.length - i - 1;
			if (j == nums.length - 1)
				forward_sum[j] = 0;
			else
				forward_sum[j] = forward_sum[j + 1] + nums[j + 1];
		}

		// System.out.println(Arrays.toString(back_sum));
		// System.out.println(Arrays.toString(forward_sum));
		for (int i = 0; i < nums.length; i++) {
			if (back_sum[i] == forward_sum[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex(nums));
	}

}

package melwin.leetcode.medium;

public class MissingElementInSortedArray {
	public static int missingElement(int[] nums, int k) {
		int total_missings = 0;
		for (int i = 1; i < nums.length; i++) {
			int current_missings = nums[i] - nums[i - 1] - 1;
			if (current_missings > 0) {
				if (k >= total_missings + 1 && k <= total_missings + current_missings) {
					return nums[i - 1] + k - total_missings;
				} else {
					total_missings += current_missings;
				}
			}
		}
		return nums[nums.length-1] + k - total_missings;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

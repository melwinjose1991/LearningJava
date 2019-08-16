package melwin.leetcode.easy;

// Arrays

public class NonDecreasingArray {
	public static boolean checkPossibility(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] <= nums[i]) {
				continue;
			} else {
				return strictCheck(nums, i - 1) || strictCheck(nums, i);
			}
		}
		return true;
	}

	private static boolean strictCheck(int[] nums, int skip_index) {
		for (int i = 1; i < nums.length; i++) {
			if (i == skip_index) {
				continue;
			}
			if (i - 1 == skip_index) {
				if (i - 2 >= 0) {
					if (nums[i - 2] <= nums[i])
						continue;
					else
						return false;
				} else {
					continue;
				}
			}
			if (nums[i - 1] <= nums[i])
				continue;
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 2, 3 };
		System.out.println(checkPossibility(nums));

		nums = new int[] { 4, 2, 3 };
		System.out.println(checkPossibility(nums));

		nums = new int[] { 4, 2, 1 };
		System.out.println(checkPossibility(nums));
	}

}

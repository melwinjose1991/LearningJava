package melwin.leetcode.easy;

// Arrays

public class MaxConsecutiveOnesII {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max_len = 0;
		for (int i = 0; i < nums.length;) {
			if (nums[i] == 1) {
				int zeros = 0, j = i + 1;
				for (j = i + 1; j < nums.length; j++) {
					if (nums[j] == 0) {
						zeros++;
						if (zeros >= 2)
							break;
					}
				}
				max_len = Math.max(max_len, j - i);
				i = i + 1;
			} else {
				int zeros = 1, j = i + 1;
				for (j = i + 1; j < nums.length; j++) {
					if (nums[j] == 0) {
						zeros++;
						if (zeros >= 2)
							break;
					}
				}
				max_len = Math.max(max_len, j - i);
				i = i + 1;
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, 1, 1, 0 };
		System.out.println(findMaxConsecutiveOnes(nums));

		nums = new int[] { 0, 0, 0, 0 };
		System.out.println(findMaxConsecutiveOnes(nums));

		nums = new int[] { 0, 1, 0, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums));
		
		nums = new int[] { 1, 1, 1, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}

}

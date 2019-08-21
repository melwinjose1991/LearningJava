package melwin.leetcode.medium;

// Bit Manipulation | XXX

public class SingleNumberII {
	public static int singleNumber(int[] nums) {
		int[] count = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 3 };
		System.out.println(singleNumber(nums));
	}

}

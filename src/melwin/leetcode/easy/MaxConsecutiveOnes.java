package melwin.leetcode.easy;

// Arrays

public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max_len = 0;
		for (int i = 0; i < nums.length;) {
			if (nums[i] == 1) {
				int start = i;
				while (i < nums.length && nums[i] == 1)
					i++;
				int len = i - start;
				max_len = Math.max(max_len, len);
			} else {
				i++;
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
	}

}

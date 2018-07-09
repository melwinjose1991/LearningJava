package melwin.leetcode.medium;

import java.util.Random;

// 398 - Random Pick Index - O(n) - Random trick

public class RandomPickIndex {

	int[] nums;
	Random rnd;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
		this.rnd = new Random();
	}

	public int pick(int target) {
		int result = -1;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			if (rnd.nextInt(++count) == 0)
				result = i;
		}

		return result;
	}

	public static void main(String[] args) {
	}

}

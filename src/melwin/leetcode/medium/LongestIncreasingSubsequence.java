package melwin.leetcode.medium;

// 300. Longest Increasing Subsequence - O(N.logN) - tails array

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		// tails is an array storing the smallest tail of all increasing
		// subsequences with length i+1 in tails[i]
		int[] tails = new int[nums.length];
		int size = 0;

		for (int x : nums) {
			int i = 0, j = size;

			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}

			// if x is larger than all tails, append it, increase the size by 1
			// if tails[i-1] < x <= tails[i], update tails[i]
			tails[i] = x;
			if (i == size)
				++size;
		}

		return size;
	}

	public static void main(String[] args) {
	}

}

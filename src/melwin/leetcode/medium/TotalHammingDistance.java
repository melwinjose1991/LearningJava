package melwin.leetcode.medium;

// 477 - Total Hamming Distance - for_every_bit(nos that have 1 * nos that have 0)

public class TotalHammingDistance {
	
	public int totalHammingDistance(int[] nums) {

		int total = 0, n = nums.length;
		for (int j = 0; j < 32; j++) {
			int bitCount = 0;
			for (int i = 0; i < n; i++)
				bitCount += (nums[i] >> j) & 1;
			total += bitCount * (n - bitCount);
		}
		return total;

	}

	public static void main(String[] args) {
	}

}

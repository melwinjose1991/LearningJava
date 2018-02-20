package melwin.leetcode.medium;

// 137 - Single Number II - O(n) / O(1) : bit-based counter for each of the 32bits

public class SingleNumberII {
	
	public int singleNumber(int[] nums) {

		int x1 = 0, x2 = 0, mask = 0;

		for (int i : nums) {
			x2 ^= x1 & i;
			x1 ^= i;
			mask = ~(x1 & x2);
			x2 &= mask;
			x1 &= mask;
		}

		return x1;
	}

	public static void main(String[] args) {
	}

}

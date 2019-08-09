package melwin.leetcode.medium;

import java.util.Arrays;

// Bit Manipulation | DP

public class CountingBits {
	public static int[] countBits(int num) {
		int[] bit_count = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			if (isPowerOfTwo(i)) {
				bit_count[i] = 1;
			} else {
				int closest_power_2 = (int) Math.pow(2, getClosestPower(i));
				bit_count[i] = bit_count[i - closest_power_2] + 1;
			}
		}
		return bit_count;
	}

	private static boolean isPowerOfTwo(int n) {
		for (int i = 0; i <= 31; i++) {
			if (Math.pow(2, i) == n)
				return true;
		}
		return false;
	}

	private static int getClosestPower(int n) {
		for (int i = 31; i >= 0; i--) {
			if (Math.pow(2, i) < n)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(16)));
	}

}

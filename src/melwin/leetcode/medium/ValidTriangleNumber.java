package melwin.leetcode.medium;

import java.util.Arrays;

// Arrays | Two Pointer

public class ValidTriangleNumber {
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int first_nonzero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				first_nonzero = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 2; i--) {
			int c = nums[i], a = first_nonzero, b = i - 1;
			while (a < b) {
				if (nums[a] + nums[b] < c) {
					a++;
				} else if (nums[a] + nums[b] == c) {
					a++;
				} else {
					count = count + (b - a);
					b--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 4 };
		System.out.println(triangleNumber(nums));
		
		nums = new int[]{ 0, 1, 1, 1 };
		System.out.println(triangleNumber(nums));
		
		nums = new int[]{ 1, 2, 3, 4, 5, 6 };
		System.out.println(triangleNumber(nums));
	}

}

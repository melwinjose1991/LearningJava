package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays 

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] != 9) {
			digits[digits.length - 1] += 1;
			return digits;
		} else {
			int carry = 1;
			for (int i = digits.length - 1; i >= 0 && carry != 0; i--) {
				int tmp = (digits[i] + carry) % 10;
				carry = (digits[i] + carry) / 10;
				digits[i] = tmp;
			}
			if (carry == 1) {
				int[] new_digits = new int[digits.length + 1];
				new_digits[0] = 1;
				return new_digits;
			} else {
				return digits;
			}
		}
	}

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(plusOne(digits)));

		digits = new int[] { 1, 2, 3, 9 };
		System.out.println(Arrays.toString(plusOne(digits)));

		digits = new int[] { 9, 9 };
		System.out.println(Arrays.toString(plusOne(digits)));
		
		digits = new int[] { 9 };
		System.out.println(Arrays.toString(plusOne(digits)));
		
		digits = new int[] { 8 };
		System.out.println(Arrays.toString(plusOne(digits)));
	}

}

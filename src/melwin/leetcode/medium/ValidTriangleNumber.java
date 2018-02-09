package melwin.leetcode.medium;

import java.util.Arrays;

// 611 - Valid Triangle Number - O(n^2) - a+b>c , fix c then find a and b

public class ValidTriangleNumber {

	public int triangleNumber(int[] A) {

		Arrays.sort(A);
		int count = 0, n = A.length;

		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (A[l] + A[r] > A[i]) {
					count += r - l;
					r--;
				} else
					l++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
	}

}

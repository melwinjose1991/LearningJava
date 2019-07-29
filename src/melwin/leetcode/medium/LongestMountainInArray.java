package melwin.leetcode.medium;

// Arrays | Pre Processing

public class LongestMountainInArray {
	public static int longestMountain(int[] A) {
		int[] back_slope = new int[A.length];
		int[] forward_slope = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				back_slope[i] = 1;
			} else {
				if (A[i - 1] < A[i]) {
					back_slope[i] = back_slope[i - 1] + 1;
				} else {
					back_slope[i] = 1;
				}
			}
			int j = A.length - i - 1;
			if (j == A.length - 1) {
				forward_slope[j] = 1;
			} else {
				if (A[j] > A[j + 1]) {
					forward_slope[j] = forward_slope[j + 1] + 1;
				} else {
					forward_slope[j] = 1;
				}
			}
		}

		int max_len = 0;
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
				max_len = Math.max(max_len, back_slope[i - 1] + 1 + forward_slope[i + 1]);
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 7, 3, 2, 5 };
		System.out.println(longestMountain(A));
	}

}

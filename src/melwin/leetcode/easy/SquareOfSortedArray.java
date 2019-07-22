package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Two Pointer

public class SquareOfSortedArray {
	public static int[] sortedSquares(int[] A) {
		int pos_ptr = 0, neg_ptr = A.length - 1;
		int[] A_sqr = new int[A.length];
		if (A[0] >= 0) {
			// All positive
			pos_ptr = 0;
			neg_ptr = -1;
		} else if (A[A.length - 1] < 0) {
			// All negative
			neg_ptr = A.length - 1;
			pos_ptr = A.length;
		} else {
			for (int i = 0; i < A.length - 1; i++) {
				if ((A[i] < 0) && (A[i + 1] >= 0)) {
					neg_ptr = i;
					pos_ptr = i + 1;
					break;
				}
			}
		}
		int i = 0;
		while (neg_ptr >= 0 && pos_ptr <= A.length - 1) {
			int pos_sqr = A[pos_ptr] * A[pos_ptr];
			int neg_sqr = A[neg_ptr] * A[neg_ptr];
			if (neg_sqr <= pos_sqr) {
				A_sqr[i] = neg_sqr;
				i++;
				neg_ptr--;
			} else {
				A_sqr[i] = pos_sqr;
				i++;
				pos_ptr++;
			}
		}
		while (neg_ptr < 0 && pos_ptr <= A.length - 1) {
			// All positive or Positive elements remaining
			A_sqr[i] = A[pos_ptr] * A[pos_ptr];
			i++;
			pos_ptr++;
		}
		while (neg_ptr >= 0 && pos_ptr > A.length - 1) {
			// All negative or negative elements remaining
			A_sqr[i] = A[neg_ptr] * A[neg_ptr];
			i++;
			neg_ptr--;
		}
		return A_sqr;
	}

	public static void main(String[] args) {
		int[] A = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(A)));

		A = new int[] { -5, -4, -3, -2, -1, 0 };
		System.out.println(Arrays.toString(sortedSquares(A)));

		A = new int[] { 0, 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(sortedSquares(A)));

		A = new int[] { -5, -4, -3, -2, -1, 0 };
		System.out.println(Arrays.toString(sortedSquares(A)));

		A = new int[] { -1, 0, 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(sortedSquares(A)));
	}

}

package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Arrays

public class IntervalListIntersections {
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		int i = 0, j = 0;
		List<int[]> result_list = new ArrayList<>();
		if (A.length == 0 || B.length == 0 || A[A.length - 1][1] < B[0][0] || B[B.length - 1][1] < A[0][0]) {
			return new int[0][];
		}
		while (i < A.length && j < B.length) {
			if ((A[i][1] >= B[j][0] && A[i][0] <= B[j][1]) || (A[i][0] <= B[j][1] && A[i][1] >= B[j][0])) {
				result_list.add(new int[] { Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1]) });
			}
			if ((j == B.length - 1) || (j + 1 < B.length && B[j + 1][0] > A[i][1])) {
				i++;
			} else if ((i == A.length - 1) || (i + 1 < A.length && A[i + 1][0] > B[j][1])) {
				j++;
			}
		}

		int[][] result_int = new int[result_list.size()][2];
		for (i = 0; i < result_int.length; i++) {
			result_int[i][0] = result_list.get(i)[0];
			result_int[i][1] = result_list.get(i)[1];
		}
		return result_int;
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		intervalIntersection(A, B);
	}

}

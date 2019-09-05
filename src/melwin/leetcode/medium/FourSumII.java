package melwin.leetcode.medium;

import java.util.HashMap;

// Hash Map

public class FourSumII {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> sum_count = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				sum_count.put(sum, sum_count.getOrDefault(sum, 0) + 1);
			}
		}

		int count = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				count += sum_count.getOrDefault(-sum, 0);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		System.out.println(fourSumCount(A, B, C, D));

	}
}

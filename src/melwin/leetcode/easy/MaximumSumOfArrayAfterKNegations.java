package melwin.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// Arrays | Two Heaps

public class MaximumSumOfArrayAfterKNegations {
	public static int largestSumAfterKNegations(int[] A, int K) {
		boolean has_zeroes = false;
		PriorityQueue<int[]> heap_neg = new PriorityQueue<>(A.length, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});

		PriorityQueue<int[]> heap_pos = new PriorityQueue<>(A.length, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				heap_pos.add(new int[] { A[i], i });
			}
			if (A[i] < 0) {
				heap_neg.add(new int[] { A[i], i });
			}
			if (A[i] == 0) {
				has_zeroes = true;
			}
		}

		if (heap_neg.size() > 0) {
			while (!heap_neg.isEmpty() && K > 0) {
				int[] ele_index = heap_neg.poll();
				A[ele_index[1]] *= -1;
				heap_pos.add(new int[] { A[ele_index[1]], ele_index[1] });
				K--;
			}
		}
		// System.out.println(K);
		if (K > 0) {
			if (K % 2 == 1) {
				if (!has_zeroes && heap_pos.size() > 0) {
					int[] ele_index = heap_pos.poll();
					A[ele_index[1]] *= -1;
				}
			}
		}
		int sum = 0;
		for (int a : A) {
			sum += a;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] A = { 4, 2, 3 };
		System.out.println(largestSumAfterKNegations(A, 1));

		A = new int[] { 3, -1, 0, 2 };
		System.out.println(largestSumAfterKNegations(A, 3));

		A = new int[] { 2, -3, -1, 5, -4 };
		System.out.println(largestSumAfterKNegations(A, 2));

		A = new int[] { -2, 5, 0, 2, -2 };
		System.out.println(largestSumAfterKNegations(A, 3));

		A = new int[] { -8, 3, -5, -3, -5, -2 };
		System.out.println(largestSumAfterKNegations(A, 6));
	}

}

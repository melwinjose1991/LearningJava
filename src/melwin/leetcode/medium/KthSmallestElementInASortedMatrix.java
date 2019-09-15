package melwin.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// Priority Queue | Heap | XXX

public class KthSmallestElementInASortedMatrix {

	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int count = 0;
		for (int j = 0; j < matrix[0].length; j++) {
			pq.add(new int[] { matrix[0][j], 0, j });
		}
		while (!pq.isEmpty()) {
			int[] n = pq.poll();
			count++;
			if (count == k) {
				return n[0];
			} else {
				int i = n[1];
				int j = n[2];
				if (i + 1 < matrix.length) {
					pq.add(new int[] { matrix[i + 1][j], i + 1, j });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		for (int i = 1; i <= 9; i++) {
			System.out.println(kthSmallest(matrix, i));
		}
	}

}

package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

// 593 - Valid Square 

public class ValidSquare {

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		int[][] points = new int[][] { { p1[0], p1[1] }, { p2[0], p2[1] }, { p3[0], p3[1] }, { p4[0], p4[1] } };
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});

		int[] A = points[0];
		int[] B = points[1];
		int[] C = points[2];
		int[] D = points[3];

		return (dist(A, B) == dist(B, D) && dist(D, C) == dist(C, A) && dist(D, C) == dist(C, A))
				&& (dist(A, D) == dist(B, C) && dist(A, B) != 0);

	}

	private static int dist(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}

	public static void main(String[] args) {
		System.out.println(ValidSquare.validSquare(new int[] { 0, 0 }, new int[] { -1, 0 }, new int[] { 1, 0 },
				new int[] { 0, 1 }));
	}

}

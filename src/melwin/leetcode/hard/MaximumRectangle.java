package melwin.leetcode.hard;

import java.util.Arrays;

// 85. Maximal Rectangle - O(n^2) - height, left & right

public class MaximumRectangle {

	// height counts the number of successive '1’s above (plus the current one)

	// left & right means the boundaries of the rectangle which contains the
	// current point with a height of value height

	int maximalRectangle(int[][] matrix) {

		if (matrix == null)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];

		Arrays.fill(left, 0);
		Arrays.fill(right, n);
		Arrays.fill(height, 0);
		int maxA = 0;

		for (int i = 0; i < m; i++) {

			int cur_left = 0, cur_right = n;

			// compute left (from left to right)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}

			// compute left (from left to right)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}

			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}

			for (int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
		}

		return maxA;
	}

	public static void main(String[] args) {
	}

}

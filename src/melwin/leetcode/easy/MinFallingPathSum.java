package melwin.leetcode.easy;

public class MinFallingPathSum {

	private static int min_sum;

	public static int minFallingPathSum(int[][] A) {
		min_sum = Integer.MAX_VALUE;
		for (int j = 0; j < A[0].length; j++) {
			fall(0, j, A, A[0][j]);
		}
		return min_sum;
	}

	public static void fall(int i, int j, int[][] A, int cur_sum) {
		if (i == A.length - 1) {
			min_sum = Math.min(cur_sum, min_sum);
			return;
		}
		if (j - 1 >= 0)
			fall(i + 1, j - 1, A, cur_sum + A[i + 1][j - 1]);
		fall(i + 1, j, A, cur_sum + A[i + 1][j]);
		if (j + 1 < A[i].length)
			fall(i + 1, j + 1, A, cur_sum + A[i + 1][j + 1]);
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 40, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(A));
	}

}

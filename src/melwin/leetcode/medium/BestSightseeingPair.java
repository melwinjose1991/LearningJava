package melwin.leetcode.medium;

// DP | 1D storage

public class BestSightseeingPair {

	public static int maxScoreSightseeingPair(int[] A) {
		int[][] dp = new int[A.length][2];
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				dp[i][0] = A[i] + i;
			} else {
				int start = A[i] + i;
				int end = A[i] - i;
				dp[i][0] = Math.max(dp[i - 1][0], start);
				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + end);
			}
		}
		return dp[dp.length - 1][1];
	}

	public static void main(String[] args) {
		int[] A = { 8, 1, 5, 2, 6 };
		System.out.println(maxScoreSightseeingPair(A));
	}

}

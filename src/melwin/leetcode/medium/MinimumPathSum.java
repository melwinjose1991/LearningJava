package melwin.leetcode.medium;

// DP | 2D Storage

public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int min_left_top = Math.min(j == 0 ? Integer.MAX_VALUE : dp[i][j - 1],
						i == 0 ? Integer.MAX_VALUE : dp[i - 1][j]);
				dp[i][j] = grid[i][j] + (i == 0 && j == 0 ? 0 : min_left_top);
				// System.out.print(dp[i][j] + " ");
			}
			// System.out.println();
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}

}

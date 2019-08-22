package melwin.leetcode.easy;

// DP | 1D Storage

public class PaintHouse {
	public static int minCost(int[][] costs) {
		if (costs.length == 0)
			return 0;
		int[][] dp = new int[costs.length][3];
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					dp[i][j] = costs[i][j];
				} else {
					switch (j) {
					case 0:
						dp[i][j] = costs[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
						break;
					case 1:
						dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
						break;
					case 2:
						dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
						break;
					}
				}
			}
		}
		return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
	}

	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		System.out.println(minCost(costs));
	}

}

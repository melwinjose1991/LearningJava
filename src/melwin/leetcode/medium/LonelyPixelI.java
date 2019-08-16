package melwin.leetcode.medium;

// DP | 2D Storage - storing row and column property

public class LonelyPixelI {
	public static int findLonelyPixel(char[][] grid) {
		int black_l = 0, black_r = 0, lonely_pixels = 0;
		if (grid.length == 0)
			return lonely_pixels;

		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			black_l = 0;
			black_r = 0;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'B') {
					dp[i][j] = black_l;
					black_l++;
				}

				int j_rev = grid[i].length - 1 - j;
				if (grid[i][j_rev] == 'B') {
					dp[i][j_rev] = black_r;
					black_r++;
				}
			}
		}

		for (int j = 0; j < grid[0].length; j++) {
			black_l = 0;
			black_r = 0;
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 'B') {
					dp[i][j] += black_l;
					black_l++;
				}
			}
			for (int i = grid.length - 1; i >= 0; i--) {
				if (grid[i][j] == 'B') {
					dp[i][j] += black_r;
					black_r++;
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (dp[i][j] == 0)
					lonely_pixels++;
			}
		}
		return lonely_pixels;
	}

	public static void main(String[] args) {
		char[][] grid = { { 'B', 'W', 'B' }, { 'W', 'B', 'W' }, { 'B', 'W', 'W' } };
		System.out.println(findLonelyPixel(grid));
	}

}

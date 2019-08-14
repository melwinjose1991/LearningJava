package melwin.leetcode.medium;

import java.util.Arrays;

public class BombEnemy {
	public static int maxKilledEnemies(char[][] grid) {
		int enemies_l = 0, enemies_r = 0, max_kill = 0;
		if (grid.length == 0)
			return max_kill;

		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			enemies_l = 0;
			enemies_r = 0;
			for (int j = 0; j < grid[i].length; j++) {
				switch (grid[i][j]) {
				case 'E':
					enemies_l++;
					dp[i][j] = 0;
					break;
				case 'W':
					enemies_l = 0;
					dp[i][j] = 0;
					break;
				case '0':
					dp[i][j] += enemies_l;
					max_kill = Math.max(max_kill, dp[i][j]);
					break;
				}
				int j_rev = grid[i].length - 1 - j;
				switch (grid[i][j_rev]) {
				case 'E':
					enemies_r++;
					dp[i][j_rev] = 0;
					break;
				case 'W':
					enemies_r = 0;
					dp[i][j_rev] = 0;
					break;
				case '0':
					dp[i][j_rev] += enemies_r;
					max_kill = Math.max(max_kill, dp[i][j_rev]);
					break;
				}
			}
		}

		for (int j = 0; j < grid[0].length; j++) {
			enemies_l = 0;
			for (int i = 0; i < grid.length; i++) {
				switch (grid[i][j]) {
				case 'E':
					enemies_l++;
					dp[i][j] = 0;
					break;
				case 'W':
					enemies_l = 0;
					dp[i][j] = 0;
					break;
				case '0':
					dp[i][j] += enemies_l;
					max_kill = Math.max(max_kill, dp[i][j]);
					break;
				}
			}
			enemies_l = 0;
			for (int i = grid.length - 1; i >= 0; i--) {
				switch (grid[i][j]) {
				case 'E':
					enemies_l++;
					dp[i][j] = 0;
					break;
				case 'W':
					enemies_l = 0;
					dp[i][j] = 0;
					break;
				case '0':
					dp[i][j] += enemies_l;
					max_kill = Math.max(max_kill, dp[i][j]);
					break;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return max_kill;
	}

	public static void main(String[] args) {
		char[][] grid = { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };
		System.out.println(maxKilledEnemies(grid));
	}

}

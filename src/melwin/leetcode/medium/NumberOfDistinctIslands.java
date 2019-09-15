package melwin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// Graph | DFS | DFS path as Key

public class NumberOfDistinctIslands {
	private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static final char[] code = { 'R', 'D', 'L', 'U' };

	public static int numDistinctIslands(int[][] grid) {
		Set<String> paths = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder path = new StringBuilder("0");
					dfs(grid, i, j, path);
					System.out.println(path);
					paths.add(path.toString());
				}
			}
		}
		return paths.size();
	}

	private static void dfs(int[][] grid, int x, int y, StringBuilder path) {
		grid[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int[] d = directions[i];
			int new_x = x + d[0];
			int new_y = y + d[1];
			if (new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length && grid[new_x][new_y] == 1) {
				path.append(code[i]);
				dfs(grid, new_x, new_y, path);
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 1, 0, 1, 1 }, { 0, 0, 1, 0 }, { 1, 0, 0, 1 } };
		System.out.println(numDistinctIslands(grid));
	}

}

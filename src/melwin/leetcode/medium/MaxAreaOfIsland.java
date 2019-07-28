package melwin.leetcode.medium;

// Graph | BFS | DFS

public class MaxAreaOfIsland {
	public static int maxAreaOfIsland(int[][] grid) {
		int max_area = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				max_area = Math.max(max_area, dfs(i, j, grid));
			}
		}
		return max_area;
	}

	private static int dfs(int i, int j, int[][] grid) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			grid[i][j] = -1;
			int left = dfs(i, j - 1, grid);
			int top = dfs(i - 1, j, grid);
			int right = dfs(i, j + 1, grid);
			int bottom = dfs(i + 1, j, grid);
			return 1 + left + top + right + bottom;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
		System.out.println(maxAreaOfIsland(grid));
	}

}

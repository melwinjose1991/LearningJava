package melwin.leetcode.medium;

// Graph | DFS

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					markIsland(grid, i, j);
				}
			}
		}
		return count;
	}

	private static int[][] moves = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	private static void markIsland(char[][] grid, int i, int j) {
		grid[i][j] = 'x';
		for (int[] move : moves) {
			int x = i + move[0];
			int y = j + move[1];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
				markIsland(grid, x, y);
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '0', '0' }, { '0', '1', '0' }, { '0', '0', '1' } };
		System.out.println(numIslands(grid));
	}

}

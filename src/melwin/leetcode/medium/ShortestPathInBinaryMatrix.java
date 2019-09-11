package melwin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// Graph | BFS

public class ShortestPathInBinaryMatrix {
	private static final int[][] directions = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 },
			{ -1, 0 }, { -1, 1 } };

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int[][] dist = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		if (grid[0][0] == 0) {
			q.add(new int[] { 1, 0, 0 });
			dist[0][0] = 1;
		}

		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] n = q.poll();
				if (n[1] == grid.length - 1 && n[2] == grid[0].length - 1) {
					return n[0];
				}
				for (int[] d : directions) {
					int new_row = n[1] + d[0];
					int new_col = n[2] + d[1];
					if (new_row >= 0 && new_row < grid.length && new_col >= 0 && new_col < grid[0].length
							&& grid[new_row][new_col] == 0 && dist[new_row][new_col] == Integer.MAX_VALUE) {
						int[] new_n = { n[0] + 1, new_row, new_col };
						q.add(new_n);
						dist[new_row][new_col] = n[0] + 1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(shortestPathBinaryMatrix(grid));
	}

}

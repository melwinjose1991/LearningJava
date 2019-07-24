package melwin.leetcode.easy;

// Arrays 

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int left_water = ((j - 1) >= 0 && grid[i][j - 1] == 0) ? 1 : 0;
					int left_boundary = (j - 1) < 0 ? 1 : 0;
					int top_water = ((i - 1) >= 0 && grid[i - 1][j] == 0) ? 1 : 0;
					int top_boundary = (i - 1) < 0 ? 1 : 0;
					int right_water = ((j + 1) < grid[i].length && grid[i][j + 1] == 0) ? 1 : 0;
					int right_boundary = (j + 1) >= grid[i].length ? 1 : 0;
					int bottom_water = ((i + 1) < grid.length && grid[i + 1][j] == 0) ? 1 : 0;
					int bottom_boundary = (i + 1) >= grid.length ? 1 : 0;
					perimeter += left_water + top_water + right_water + bottom_water;
					perimeter += left_boundary + top_boundary + right_boundary + bottom_boundary;
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
	}

}

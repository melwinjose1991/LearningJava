package melwin.leetcode.medium;

// Arrays | Binary Search

public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int i = 0, j = (matrix.length * matrix[0].length) - 1;
		while (i <= j) {
			int r = ((i + j) / 2) / matrix[0].length;
			int c = ((i + j) / 2) % matrix[0].length;
			if (matrix[r][c] == target) {
				return true;
			} else if (matrix[r][c] > target) {
				j = ((i + j) / 2) - 1;
			} else {
				i = ((i + j) / 2) + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 13));
	}

}

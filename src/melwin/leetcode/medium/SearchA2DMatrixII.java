package melwin.leetcode.medium;

// Matrix | Arrays | Search

public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int i = 0, j = matrix[0].length - 1;
		while (i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1) {
			if (matrix[i][j] == target)
				return true;
			else {
				if (matrix[i][j] < target)
					i++;
				else
					j--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
	}

}

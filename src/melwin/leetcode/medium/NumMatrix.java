package melwin.leetcode.medium;

// Arrays | Pre Processing

public class NumMatrix {

	private int[][] sum;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0)
			return;
		sum = new int[matrix.length][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= matrix[i].length; j++) {
				sum[i][j] = (j == 0 ? 0 : sum[i][j - 1]) + (j == 0 ? 0 : matrix[i][j - 1]);
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int range_sum = 0;
		for (int i = row1; i <= row2; i++) {
			range_sum += (sum[i][col2 + 1] - sum[i][col1]);
		}
		return range_sum;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		NumMatrix matrix_obj = new NumMatrix(matrix);
		System.out.println(matrix_obj.sumRegion(2, 0, 2, 2));
	}

}

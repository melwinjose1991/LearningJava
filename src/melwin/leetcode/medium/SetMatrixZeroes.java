package melwin.leetcode.medium;

// Arrays

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < cols.length; j++) {
			if (cols[j] == 1) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

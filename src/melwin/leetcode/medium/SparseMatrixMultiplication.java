package melwin.leetcode.medium;

// Leetcode - 311 - Sparse Matrix Multiplication - O(m.n.nB)
// Multiply only the non-zero elements

public class SparseMatrixMultiplication {
	
	public int[][] multiply(int[][] A, int[][] B) {
		int m = A.length, n = A[0].length, nB = B[0].length;
		int[][] C = new int[m][nB];

		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < nB; j++) {
						if (B[k][j] != 0)
							C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
		return C;
	}

	public static void main(String[] args) {
	}

}

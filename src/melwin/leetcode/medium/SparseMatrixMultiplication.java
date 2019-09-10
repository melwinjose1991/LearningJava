package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

// Arrays | HashMaps

public class SparseMatrixMultiplication {
	public static int[][] multiply(int[][] A, int[][] B) {
		HashMap<Integer, HashMap<Integer, Integer>> A_rc_map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			HashMap<Integer, Integer> tmp = new HashMap<>();
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != 0) {
					tmp.put(j, A[i][j]);
				}
			}
			if (tmp.size() != 0) {
				A_rc_map.put(i, tmp);
			}
		}
		HashMap<Integer, HashMap<Integer, Integer>> B_cr_map = new HashMap<>();
		for (int j = 0; j < B[0].length; j++) {
			HashMap<Integer, Integer> tmp = new HashMap<>();
			for (int i = 0; i < B.length; i++) {
				if (B[i][j] != 0) {
					tmp.put(i, B[i][j]);
				}
			}
			if (tmp.size() != 0) {
				B_cr_map.put(j, tmp);
			}
		}

		int[][] c = new int[A.length][B[0].length];
		for (int A_row : A_rc_map.keySet()) {
			HashMap<Integer, Integer> A_row_elements = A_rc_map.get(A_row);
			for (int B_col : B_cr_map.keySet()) {
				HashMap<Integer, Integer> B_col_elements = B_cr_map.get(B_col);
				int sum = 0;
				for (int A_col : A_row_elements.keySet()) {
					int A_val = A_row_elements.get(A_col);
					if (B_col_elements.containsKey(A_col)) {
						int B_val = B_col_elements.get(A_col);
						sum += (A_val * B_val);
					}
				}
				c[A_row][B_col] = sum;
			}
			System.out.println(Arrays.toString(c[A_row]));
		}
		return c;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 0, 0 }, { -1, 0, 3 } };
		int[][] B = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		// multiply(A, B);

		A = new int[][] { { 1, -5 } };
		B = new int[][] { { 12 }, { -1 } };
		multiply(A, B);
	}

}

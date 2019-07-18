package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays

public class ReshapeTheMatrix {

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int old_r = nums.length;
		int old_c = nums[0].length;
		if (r * c != old_r * old_c) {
			return nums;
		}
		int curr_element_index = 0;
		int[][] reshaped_nums = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int row = curr_element_index / old_c;
				int col = curr_element_index % old_c;
				reshaped_nums[i][j] = nums[row][col];
				curr_element_index++;
			}
		}
		return reshaped_nums;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.deepToString(matrixReshape(nums, 1, 4)));
		System.out.println(Arrays.deepToString(matrixReshape(nums, 2, 4)));
		
		nums = new int[][]{ { 1, 2, 3, 4 } };
		System.out.println(Arrays.deepToString(matrixReshape(nums, 2, 2)));
	}

}

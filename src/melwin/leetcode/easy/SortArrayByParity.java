package melwin.leetcode.easy;

import java.util.Arrays;

// Array | Two Pointer Technique

public class SortArrayByParity {

	public static int[] sortArrayByParity(int[] A) {
		int left_pointer = 0;
		int right_pointer = A.length - 1;
		while (left_pointer < right_pointer) {
			// System.out.println(left_pointer + " " + right_pointer);
			if (A[left_pointer] % 2 != 0) {
				while (A[right_pointer] % 2 == 1 & left_pointer < right_pointer)
					right_pointer--;
				if (left_pointer < right_pointer) {
					int tmp = A[left_pointer];
					A[left_pointer] = A[right_pointer];
					A[right_pointer] = tmp;
					left_pointer++;
					right_pointer--;
				}
			}else {
				left_pointer++;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		
		A = new int[]{ 1 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		
		A = new int[]{ 2, 3, 4, 6, 1 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		
		A = new int[]{ 2, 4, 6, 8 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		
		A = new int[]{ 1, 3, 5, 7 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
		
		A = new int[]{ 2, 4, 6, 8, 1, 3, 5, 7 };
		System.out.println(Arrays.toString(sortArrayByParity(A)));
	}

}

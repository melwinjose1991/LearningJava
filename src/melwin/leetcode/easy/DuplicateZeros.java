package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Shifting | Easy

public class DuplicateZeros {
	public static void duplicateZeros(int[] arr) {
		int copied = 0, last_index = 0;
		boolean duplicate_last_zero = false;
		for (last_index = 0; last_index < arr.length; last_index++) {
			if (arr[last_index] == 0) {
				copied++;
				if (copied == arr.length)
					break;
				copied++;
				if (copied == arr.length) {
					duplicate_last_zero = true;
					break;
				}
			} else {
				copied++;
				if (copied == arr.length)
					break;
			}

		}
		for (int i = arr.length - 1, j = last_index; j >= 0; j--) {
			if (j == last_index && arr[j] == 0 && !duplicate_last_zero)
				arr[i--] = 0;
			else if (arr[j] == 0) {
				arr[i--] = 0;
				arr[i--] = 0;
			} else {
				arr[i--] = arr[j];
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
		duplicateZeros(arr);
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 1, 2, 3 };
		duplicateZeros(arr);
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 1, 0 };
		duplicateZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

}

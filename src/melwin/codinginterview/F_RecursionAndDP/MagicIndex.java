package melwin.codinginterview.F_RecursionAndDP;

import java.util.Arrays;

public class MagicIndex {
	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);

		return right;
	}

	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public static int[] getSortedArray(int size) {
		int[] array = { 0, 2, 3, 3, 10, 10, 20, 30, 70, 80 };
		Arrays.sort(array);
		return array;
	}

	public static void main(String[] args) {
		int[] array = getSortedArray(20);
		int index = magicFast(array);
		System.out.println(array[index]);
	}
}

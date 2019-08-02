package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Arrays | Binary Search | Medium

public class FindKClosestElements {
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		int i = 0, j = 0;
		int index = Arrays.binarySearch(arr, x);
		if (index == 0 || (index < 0 && (-index - 1) == 0)) {
			i = -1;
			j = 0;
		} else if ((index == arr.length - 1) || (index < 0 && (-index - 1) == arr.length)) {
			i = arr.length - 1;
			j = arr.length;
		} else {
			if (index < 0) {
				index = -index - 1;
				i = index - 1;
				j = index;
			} else {
				i = index;
				j = index + 1;
			}

		}
		// System.out.println(i + " " + j);
		List<Integer> result = new ArrayList<Integer>();
		while (i >= 0 && j < arr.length && result.size() < k) {
			if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
				result.add(arr[i--]);
			} else {
				result.add(arr[j++]);
			}
		}
		while (i >= 0 && result.size() < k) {
			result.add(arr[i--]);
		}
		while (j < arr.length && result.size() < k) {
			result.add(arr[j++]);
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(findClosestElements(arr, 4, 3));

		arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(findClosestElements(arr, 4, -1));
	}

}

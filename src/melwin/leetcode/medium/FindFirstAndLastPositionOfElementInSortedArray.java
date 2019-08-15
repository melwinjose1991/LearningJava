package melwin.leetcode.medium;

import java.util.Arrays;

// Arrays | Sorting | Binary Search

public class FindFirstAndLastPositionOfElementInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		int i = 0, j = nums.length - 1, index = -1;
		boolean found = false;
		while (i <= j) {
			if (i == j) {
				if (nums[i] == target) {
					found = true;
					index = i;
				}
				break;
			} else {
				int mid = (i + j) / 2;
				if (nums[mid] > target) {
					j = mid - 1;
				} else if (nums[mid] < target) {
					i = mid + 1;
				} else {
					found = true;
					index = mid;
					break;
				}
			}
		}
		if (found) {
			i = index;
			while (i > 0 && nums[i - 1] == target)
				i--;
			j = index;
			while (j < nums.length - 1 && nums[j + 1] == target)
				j++;
			return new int[] { i, j };
		} else {
			return new int[] { -1, -1 };
		}

	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(nums, 8)));

		nums = new int[] { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(nums, 6)));

		nums = new int[] { 6, 6, 6 };
		System.out.println(Arrays.toString(searchRange(nums, 6)));
		
		nums = new int[] { 1 };
		System.out.println(Arrays.toString(searchRange(nums, 1)));
	}

}

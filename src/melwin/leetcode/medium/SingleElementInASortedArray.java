package melwin.leetcode.medium;

// Array | Medium | Binary Search

public class SingleElementInASortedArray {
	public static int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		else
			return binarySearch(nums, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int i, int j) {
		// System.out.println("@" + i + " " + j);
		if (i + 1 == j || i == j)
			return nums[i];
		int mid = (i + j) / 2;
		if ((mid - i + 1) % 2 == 1) {
			if (nums[mid] == nums[mid - 1]) {
				return binarySearch(nums, i, mid);
			} else {
				return binarySearch(nums, mid, j);
			}
		} else {
			if (nums[mid] == nums[mid - 1]) {
				return binarySearch(nums, mid + 1, j);
			} else {
				return binarySearch(nums, i, mid);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		System.out.println(singleNonDuplicate(nums));
	}

}

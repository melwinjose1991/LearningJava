package melwin.leetcode.easy;

// Arrays | BinarySearch | Easy

public class InsertSearchPosition {
	public static int searchInsert(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private static int binarySearch(int[] nums, int i, int j, int ele) {
		if (ele < nums[i])
			return i;
		if (ele > nums[j])
			return j + 1;
		int mid = nums[(i + j) / 2];
		if (mid == ele)
			return (i + j) / 2;
		if (mid > ele)
			return binarySearch(nums, i, j - 1, ele);
		else
			return binarySearch(nums, i + 1, j, ele);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 5));

		nums = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 2));

		nums = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 7));

		nums = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 0));
	}

}

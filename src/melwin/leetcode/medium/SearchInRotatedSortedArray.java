package melwin.leetcode.medium;

// Binary Search | Arrays

public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			if (l + 1 == r) {
				return nums[l] == target ? l : (nums[r] == target ? r : -1);
			}
			int m = (l + r) / 2;
			if (nums[m] == target)
				return m;

			if (nums[l] < nums[m] && nums[m] < nums[r]) {
				// Normal
				if (target > nums[m])
					l = m + 1;
				else
					r = m - 1;
			} else if (nums[l] < nums[m] && nums[m] > nums[r]) {
				// Left shifted
				if (target >= nums[l] && target < nums[m])
					r = m - 1;
				else
					l = m + 1;
			} else {
				// Right shifted
				if (target > nums[m] && target <= nums[r])
					l = m + 1;
				else
					r = m - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(nums, 4));
		System.out.println(search(nums, 5));
		System.out.println(search(nums, 6));
		System.out.println(search(nums, 7));
		System.out.println(search(nums, 0));
		System.out.println(search(nums, 1));
		System.out.println(search(nums, 2));

		System.out.println(search(nums, 3));
		System.out.println(search(nums, 8));
		System.out.println(search(nums, -1));
	}

}

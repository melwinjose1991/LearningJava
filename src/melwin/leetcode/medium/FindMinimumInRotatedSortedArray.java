package melwin.leetcode.medium;

// Binary Search

public class FindMinimumInRotatedSortedArray {

	public static int findMin(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			if (l == r)
				return nums[l];
			if (l + 1 == r)
				return Math.min(nums[l], nums[r]);
			int m = (l + r) / 2;
			if (nums[l] < nums[m] && nums[m] < nums[r]) {
				return nums[l];
			} else if (nums[l] > nums[m] && nums[m] < nums[r]) {
				r = m;
			} else if (nums[l] < nums[m] && nums[m] > nums[r]) {
				l = m;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
	}

}

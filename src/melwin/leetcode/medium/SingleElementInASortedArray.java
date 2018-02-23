package melwin.leetcode.medium;

// 540. Single Element in a Sorted Array - O(logN)

public class SingleElementInASortedArray {
	public static int singleNonDuplicate(int[] nums) {
		int start = 0, end = nums.length - 1;

		// Assuming that left doesn't have the single element
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid % 2 == 1)
				mid--;

			// Assumption becomes wrong here
			if (nums[mid] != nums[mid + 1])
				end = mid;

			else
				start = mid + 2;
		}

		return nums[start];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

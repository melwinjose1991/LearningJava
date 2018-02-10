package melwin.leetcode.medium;

// 80 - Remove Duplicates From Sorted Array II - O(n)

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		int i = 0;

		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;

		return i;
	}

	public static void main(String[] args) {
	}

}

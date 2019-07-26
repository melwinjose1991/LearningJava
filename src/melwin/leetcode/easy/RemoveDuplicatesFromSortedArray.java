package melwin.leetcode.easy;

// Arrays

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int prev_element = nums[0];
		int unique_elements = 1;
		int write_index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev_element) {
				continue;
			} else {
				unique_elements++;
				prev_element = nums[i];
				nums[write_index++] = prev_element;
			}

		}
		return unique_elements;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(nums));
	}

}

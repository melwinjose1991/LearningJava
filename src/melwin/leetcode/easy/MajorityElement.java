package melwin.leetcode.easy;

// Arrays | XXX

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		int majority_ele = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == majority_ele) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majority_ele = nums[i];
				count = 1;
			}
		}
		return majority_ele;
	}

	public static void main(String[] args) {
	}

}

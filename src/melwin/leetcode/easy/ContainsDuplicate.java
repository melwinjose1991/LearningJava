package melwin.leetcode.easy;

import java.util.HashSet;

// Hash Set

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (!set.add(n)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(containsDuplicate(nums));

		nums = new int[] { 1, 2, 3, 1 };
		System.out.println(containsDuplicate(nums));

		nums = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		System.out.println(containsDuplicate(nums));
	}

}

package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Arrays | Permutation | Medium

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		boolean[] used_marker = new boolean[nums.length];
		getPermutations(new ArrayList<>(), nums, used_marker, results);
		return results;
	}

	private static void getPermutations(List<Integer> list, int[] nums, boolean[] used_marker,
			List<List<Integer>> results) {
		if (list.size() == nums.length) {
			System.out.println(list);
			results.add(new ArrayList<>(list));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used_marker[i] == false) {
					used_marker[i] = true;
					list.add(nums[i]);
					getPermutations(list, nums, used_marker, results);
					used_marker[i] = false;
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		permute(nums);
	}

}

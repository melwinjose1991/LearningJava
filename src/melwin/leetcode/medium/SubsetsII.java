package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Permutation | Combination | XXX

public class SubsetsII {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	public static void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {

		System.out.println(path);
		result.add(path);

		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;

			List<Integer> new_path = new ArrayList<>(path);
			new_path.add(nums[i]);
			dfs(nums, i + 1, new_path, result);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		subsetsWithDup(nums);
	}

}

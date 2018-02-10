package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LEETCODE - 90 - SubSets II - SORT + DFS + save every time

public class SubSetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));

		// this loop is trying to fix the next element
		for (int i = start; i < nums.length; i++) {

			// if the next element is same as the last one
			// in the loop, not the last in the tempList
			if (i > start && nums[i] == nums[i - 1])
				continue;

			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
	}

}

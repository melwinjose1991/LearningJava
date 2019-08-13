package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Arrays | Permutation Combination | XXX

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 4; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			for (int j = i + 1; j <= nums.length - 3; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j])
					continue;
				for (int k = j + 1; k <= nums.length - 2; k++) {
					if (k > j + 1 && nums[k - 1] == nums[k])
						continue;
					if (nums[k + 1] > target - (nums[i] + nums[j] + nums[k]))
						continue;

					int l = Arrays.binarySearch(Arrays.copyOfRange(nums, k + 1, nums.length),
							target - (nums[i] + nums[j] + nums[k]));
					if (l >= 0) {
						// System.out.println(i + "-" + j + "-" + k + "-" + l);
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);
						tmp.add(nums[k + 1 + l]);
						result.add(tmp);
						System.out.println(tmp);
					}

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		fourSum(nums, 0);
	}

}

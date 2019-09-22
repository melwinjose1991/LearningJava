package melwin.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

// Arrays | HashMaps

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (map.containsKey(target - n)) {
				return new int[] { i, map.get(target - n) };
			}
			map.put(n, i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(a, 9)));
	}

}

package melwin.leetcode.easy;

import java.util.HashMap;

public class DegreeOfAnArray {
	public static int findShortestSubArray(int[] nums) {
		HashMap<Integer, int[]> map = new HashMap<>();
		int max_len = 0, min_len = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new int[] { 1, i, i });
			} else {
				map.get(nums[i])[0] += 1;
				map.get(nums[i])[2] = i;
			}
		}
		for (int num : map.keySet()) {
			// System.out.println("@" + num + " " + Arrays.toString(map.get(num)));
			if (map.get(num)[0] > max_len) {
				max_len = map.get(num)[0];
				min_len = map.get(num)[2] - map.get(num)[1] + 1;
			} else if ((map.get(num)[0] == max_len) && (min_len > map.get(num)[2] - map.get(num)[1] + 1)) {
				max_len = map.get(num)[0];
				min_len = map.get(num)[2] - map.get(num)[1] + 1;

			}
		}
		return min_len;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };
		System.out.println(findShortestSubArray(nums));

		nums = new int[] { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(findShortestSubArray(nums));
	}

}

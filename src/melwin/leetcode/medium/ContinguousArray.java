package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// 525 - Contiguous Array - O(n) - change 0 to -1

public class ContinguousArray {
	
	public int findMaxLength(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(0, -1);
		int sum = 0, max = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumToIndex.containsKey(sum)) {
				max = Math.max(max, i - sumToIndex.get(sum));
			} else {
				sumToIndex.put(sum, i);
			}
		}

		return max;
	}

	public static void main(String[] args) {
	}

}

package melwin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 1 - Two Sum - O(n)

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}

			// the code lines below avoids the "duplicate keys" problem
			if (map.containsKey(numbers[i])) {
				continue;
			}

			map.put(numbers[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
	}

}

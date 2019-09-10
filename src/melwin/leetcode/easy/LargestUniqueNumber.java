package melwin.leetcode.easy;

import java.util.HashMap;

// HashMap

public class LargestUniqueNumber {
	public int largestUniqueNumber(int[] A) {
		HashMap<Integer, Integer> num_count = new HashMap<>();
		int num = -1;
		for (int a : A) {
			num_count.put(a, num_count.getOrDefault(a, 0) + 1);
		}
		for (int key : num_count.keySet()) {
			if (num_count.get(key) == 1 && key > num) {
				num = key;
			}
		}
		return num;
	}

	public static void main(String[] args) {
	}

}

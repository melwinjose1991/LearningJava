package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// Arrays | HashMap

public class MaxLengthOfPairChain {
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		HashMap<Integer, Integer> map = new HashMap<>();
		int max_len = 0;
		for (int[] p : pairs) {
			map.put(p[1], map.getOrDefault(p[1], 1));
			for (int b : map.keySet()) {
				if (b < p[0]) {
					map.put(p[1], Math.max(map.get(b) + 1, map.get(p[1])));
				}
			}
			max_len = Math.max(max_len, map.get(p[1]));
		}
		return max_len;
	}

	public static void main(String[] args) {
		int[][] pairs = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(findLongestChain(pairs));
	}

}

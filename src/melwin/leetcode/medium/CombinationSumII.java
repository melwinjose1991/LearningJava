package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Arrays | Permutation Combinations | XXX

public class CombinationSumII {
	private static List<List<Integer>> results;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		results = new ArrayList<List<Integer>>();
		combinations(new ArrayList<>(), candidates, 0, 0, target);
		return results;
	}

	private static void combinations(List<Integer> list, int[] c, int i, int sum, int t) {
		if (sum > t) {
			return;
		} else if (sum == t) {
			/*
			 * boolean exists = false; for (List<Integer> l : results) { if (l.equals(list))
			 * { exists = true; } } if (!exists)
			 */
			// System.out.println(list);
			results.add(new ArrayList<Integer>(list));
		} else {
			if (i < c.length) {
				for (int j = i; j < c.length; j++) {
					if (j > i && c[j] == c[j - 1])
						continue;
					list.add(c[j]);
					combinations(list, c, j + 1, sum + c[j], t);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] c = { 10, 1, 2, 7, 6, 1, 5 };
		combinationSum2(c, 8);

		c = new int[] { 2, 5, 2, 1, 2 };
		combinationSum2(c, 5);
	}

}

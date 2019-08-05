package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Arrays | Combination | XXX

public class CombinationSum {
	private static List<List<Integer>> results;

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		results = new ArrayList<List<Integer>>();
		checkCombinations(new ArrayList<>(), candidates, 0, target);
		return results;
	}

	private static void checkCombinations(List<Integer> list, int[] c, int i, int t) {
		if (t == 0) {
			/*for (List<Integer> l : results) {
				if (l.equals(list)) {
					return;
				}
			}*/
			System.out.println(list);
			results.add(new ArrayList<>(list));
		} else {
			for (int j = i; j < c.length; j++) {
				if (c[j] <= t) {
					list.add(c[j]);
					checkCombinations(list, c, j, t - c[j]);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		combinationSum(candidates, target);
	}

}

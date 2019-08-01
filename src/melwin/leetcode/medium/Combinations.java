package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 

public class Combinations {
	private static List<List<Integer>> results;

	public static List<List<Integer>> combine(int n, int k) {
		results = new ArrayList<List<Integer>>();
		getCombinations(1, n, k, new ArrayList<>());
		return results;
	}

	private static void getCombinations(int i, int n, int k, List<Integer> list) {
		if (i > n + 1)
			return;
		if (list.size() == k) {
			// System.out.println(list);
			results.add(new ArrayList<>(list));
		} else {
			list.add(i);
			getCombinations(i + 1, n, k, list);
			list.remove(list.size() - 1);

			getCombinations(i + 1, n, k, list);
		}
	}

	public static void main(String[] args) {
		combine(5, 2);
	}

}

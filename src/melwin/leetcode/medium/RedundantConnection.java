package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

// Union Find | Tree | Graph

public class RedundantConnection {

	private static HashMap<Integer, Integer> union_set;

	public static int[] findRedundantConnection(int[][] edges) {
		union_set = new HashMap<>();
		for (int[] edge : edges) {
			if (!doUnion(edge[0], edge[1]))
				return edge;
		}
		return new int[] { 0, 0 };
	}

	private static int getHead(int n) {
		if (!union_set.containsKey(n)) {
			union_set.put(n, n);
			return n;
		} else {
			while (union_set.get(n) != n) {
				n = union_set.get(n);
			}
			return n;
		}
	}

	private static boolean doUnion(int a, int b) {
		if (getHead(a) == getHead(b)) {
			return false;
		} else {
			int b_head = getHead(b);
			int a_head = getHead(a);
			union_set.put(a_head, b_head);
			return true;
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		System.out.println(Arrays.toString(findRedundantConnection(edges)));

		edges = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}

}

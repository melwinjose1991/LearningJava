package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Graphs | Trees | Removing Leaves | Medium

public class MinimumHeightTree {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
		int nodes_left = n;
		for (int i = 0; i < n; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1) {
				q.add(i);
			}
		}

		while (nodes_left != 1 && nodes_left != 2) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int node = q.poll();
				for (int neighbors : graph.get(node)) {
					graph.get(neighbors).remove((Integer) node);
					if (graph.get(neighbors).size() == 1) {
						q.add(neighbors);
					}
				}
				graph.set(node, null);
				nodes_left--;
			}
		}
		// System.out.println(q);
		if (q.size() == 0) {
			q.add(0);
			return new ArrayList<>(q);
		} else
			return new ArrayList<>(q);
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		int n = 6;
		System.out.println(findMinHeightTrees(n, edges));

		edges = new int[][] { { 0, 1 } };
		n = 2;
		System.out.println(findMinHeightTrees(n, edges));

		edges = new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		n = 4;
		System.out.println(findMinHeightTrees(n, edges));
	}

}

package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Graphs | BFS

public class GraphValidTree {
	public static boolean validTree(int n, int[][] edges) {
		if (edges.length == 0) {
			if (n == 1)
				return true;
			else
				return false;
		}
		if (edges.length != n - 1)
			return false;
		boolean[] color = new boolean[n];
		HashMap<Integer, List<Integer>> g = new HashMap<>();
		constructGraph(edges, g);
		if (!dfs(edges[0][0], edges[0][0], g, color))
			return false;
		else {
			for (int i = 0; i < n; i++) {
				if (!color[i])
					return false;
			}
			return true;
		}
	}

	private static boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> g, boolean[] color) {
		color[node] = true;
		for (int n : g.get(node)) {
			if (n == parent)
				continue;
			if (color[n] == false) {
				if (!dfs(n, node, g, color))
					return false;
			} else {
				return false;
			}
		}
		return true;
	}

	private static void constructGraph(int[][] edges, HashMap<Integer, List<Integer>> g) {
		for (int[] sd : edges) {
			if (g.containsKey(sd[0])) {
				g.get(sd[0]).add(sd[1]);
			} else {
				List<Integer> neighbors = new ArrayList<Integer>();
				neighbors.add(sd[1]);
				g.put(sd[0], neighbors);
			}
			if (g.containsKey(sd[1])) {
				g.get(sd[1]).add(sd[0]);
			} else {
				List<Integer> neighbors = new ArrayList<Integer>();
				neighbors.add(sd[0]);
				g.put(sd[1], neighbors);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		System.out.println(validTree(5, edges));

		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree(5, edges));

		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 } };
		System.out.println(validTree(5, edges));
	}

}

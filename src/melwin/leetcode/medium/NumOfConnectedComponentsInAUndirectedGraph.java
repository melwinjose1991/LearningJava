package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Graph | DFS

public class NumOfConnectedComponentsInAUndirectedGraph {
	public static int countComponents(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> g = new HashMap<>();
		boolean[] visited = new boolean[n];
		for (int[] sd : edges) {
			if (!g.containsKey(sd[0])) {
				g.put(sd[0], new ArrayList<>());
			}
			g.get(sd[0]).add(sd[1]);

			if (!g.containsKey(sd[1])) {
				g.put(sd[1], new ArrayList<>());
			}
			g.get(sd[1]).add(sd[0]);
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				dfs(g, visited, i);
			}
		}
		return count;
	}

	private static void dfs(HashMap<Integer, List<Integer>> g, boolean[] visited, int node) {
		visited[node] = true;
		if(!g.containsKey(node))
			return;
		for (int neighbor : g.get(node)) {
			if (!visited[neighbor]) {
				dfs(g, visited, neighbor);
			}
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		System.out.println(countComponents(5, edges));

		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(countComponents(5, edges));
	}

}

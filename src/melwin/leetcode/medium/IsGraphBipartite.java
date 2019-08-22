package melwin.leetcode.medium;

// DFS on edges

public class IsGraphBipartite {
	public static boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			if (color[i] == 0) {
				if (!dfs(graph, i, color)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(int[][] g, int src, int[] colors) {
		if (colors[src] == 0)
			colors[src] = 1;
		for (int dst : g[src]) {
			if (colors[dst] == 0) {
				colors[dst] = colors[src] == 1 ? 2 : 1;
				if (!dfs(g, dst, colors))
					return false;
			} else if (colors[src] != colors[dst]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(isBipartite(graph));

		graph = new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		System.out.println(isBipartite(graph));

		graph = new int[][] { { 1 }, { 0, 3 }, { 3 }, { 1, 2 } };
		System.out.println(isBipartite(graph));

		graph = new int[][] { { 1, 3 }, { 0, 2, }, { 1 }, { 0 } };
		System.out.println(isBipartite(graph));

	}

}

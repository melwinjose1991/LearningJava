package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Graph | Loop | Topological Sort

public class CourseScheduleII {

	private static boolean loop;

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> g = new HashMap<>();
		for (int[] e : prerequisites) {
			if (!g.containsKey(e[1])) {
				g.put(e[1], new ArrayList<>());
			}
			g.get(e[1]).add(e[0]);
		}

		loop = false;
		int[] visited = new int[numCourses];
		List<Integer> result_list = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				dfs(g, i, visited, result_list);
			}
		}
		if (loop)
			return new int[1];

		Collections.reverse(result_list);
		System.out.println(result_list);
		int[] result_int = new int[result_list.size()];
		for (int i = 0; i < result_list.size(); i++) {
			result_int[i] = result_list.get(i);
		}
		return result_int;
	}

	private static void dfs(HashMap<Integer, List<Integer>> g, int node, int[] visited, List<Integer> result_list) {
		visited[node] = 1;
		if (g.containsKey(node)) {
			for (int neighbor : g.get(node)) {
				if (visited[neighbor] == 0)
					dfs(g, neighbor, visited, result_list);
				if (visited[neighbor] == 1)
					loop = true;
			}
		}
		visited[node] = 2;
		result_list.add(node);
	}

	public static void main(String[] args) {
		int[][] pre = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		findOrder(4, pre);

		pre = new int[][] { { 0, 1 } };
		findOrder(2, pre);

		pre = new int[][] { { 0, 1 }, { 1, 0 } };
		findOrder(2, pre);
	}

}

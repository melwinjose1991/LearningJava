package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Tree | DFS

public class KillProcess {
	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			int parent = ppid.get(i);
			int child = pid.get(i);
			if (!map.containsKey(parent)) {
				map.put(parent, new HashSet<>());
			}
			map.get(parent).add(child);
		}
		List<Integer> result = new ArrayList<>();
		dfs(map, kill, result);
		return result;
	}

	private static void dfs(HashMap<Integer, Set<Integer>> map, int node, List<Integer> result) {
		result.add(node);
		if (map.containsKey(node)) {
			for (int child : map.get(node)) {
				dfs(map, child, result);
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);

		List<Integer> ppid = new ArrayList<>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);

		System.out.println(killProcess(pid, ppid, 5));
	}

}

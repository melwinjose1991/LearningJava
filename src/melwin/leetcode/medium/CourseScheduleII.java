package melwin.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.List;

// 210 - Course Schedule II

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incLinkCounts = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<>(numCourses);
		initialiseGraph(incLinkCounts, adjs, prerequisites);
		return solveByDFS(adjs);
	}

	private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
		int n = incLinkCounts.length;
		while (n-- > 0)
			adjs.add(new ArrayList<>());
		for (int[] edge : prerequisites) {
			incLinkCounts[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
	}

	private int[] solveByDFS(List<List<Integer>> adjs) {
		BitSet visited = new BitSet(adjs.size());
		BitSet onStack = new BitSet(adjs.size());
		
		Deque<Integer> order = new ArrayDeque<>();
		for (int i = adjs.size() - 1; i >= 0; i--) {
			if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false)
				return new int[0];
		}
		
		int[] orderArray = new int[adjs.size()];
		for (int i = 0; !order.isEmpty(); i++)
			orderArray[i] = order.pop();
		
		return orderArray;
	}

	private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
		visited.set(from);
		onStack.set(from);
		
		for (int to : adjs.get(from)) {
			if (visited.get(to) == false) {
				if (hasOrder(to, adjs, visited, onStack, order) == false)
					return false;
			} else if (onStack.get(to) == true) {
				return false;
			}
		}
		
		onStack.clear(from);
		order.push(from);
		return true;
	}

	public static void main(String[] args) {
	}

}

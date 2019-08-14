package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Graph | BFS | XXX

public class ShortestPathWithAlternatingColors {
	private static List<List<List<Integer>>> m;

	public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		m = new ArrayList<List<List<Integer>>>(n);
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			if (i > 0)
				dist[i] = Integer.MAX_VALUE;
			m.add(new ArrayList<List<Integer>>());
		}
		int lvl = 1;
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		for (int[] sd : red_edges) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			tmp.add(sd[1]);
			if (sd[0] == 0) {
				q.add(tmp);
			} else {
				m.get(sd[0]).add(tmp);
			}
		}
		for (int[] sd : blue_edges) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(2);
			tmp.add(sd[1]);
			if (sd[0] == 0) {
				q.add(tmp);
			} else {
				m.get(sd[0]).add(tmp);
			}
		}
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				List<Integer> tmp = q.poll();
				// System.out.println("Popped" + tmp);
				int color = tmp.get(0);
				int node = tmp.get(1);
				dist[node] = Math.min(dist[node], lvl);
				List<List<Integer>> new_neighbors = new ArrayList<List<Integer>>();
				for (int j = 0; j < m.get(node).size(); j++) {
					List<Integer> edge = m.get(node).get(j);
					// System.out.println("\tNeighbor:" + edge);
					if (edge.get(0) != color) {
						// System.out.println("\t\tPushed" + edge);
						q.add(edge);
					} else {
						new_neighbors.add(edge);
					}
				}
				m.set(node, new_neighbors);
				// printM();
			}
			lvl++;
		}
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				dist[i] = -1;
		}
		return dist;

	}

	private static void printM() {
		for (int i = 0; i < m.size(); i++) {
			System.out.print("@" + i);
			for (int j = 0; j < m.get(i).size(); j++) {
				System.out.print(m.get(i).get(j) + " || ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] red = { { 0, 1 }, { 1, 2 } };
		int[][] blue = { { 0, 1 }, { 1, 2 } };
		System.out.println(Arrays.toString(shortestAlternatingPaths(3, red, blue)));

		red = new int[][] { { 1, 0 } };
		blue = new int[][] { { 2, 1 } };
		System.out.println(Arrays.toString(shortestAlternatingPaths(3, red, blue)));

		red = new int[][] { { 0, 1 }, { 0, 2 } };
		blue = new int[][] { { 1, 0 } };
		System.out.println(Arrays.toString(shortestAlternatingPaths(3, red, blue)));

		red = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		blue = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		System.out.println(Arrays.toString(shortestAlternatingPaths(5, red, blue)));
	}

}

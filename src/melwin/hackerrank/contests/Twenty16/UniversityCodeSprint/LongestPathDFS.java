package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LongestPathDFS {

	private static final int BLACK = -1, GRAY = 0, WHITE = 1;

	static class Node {
		public int status;
		public ArrayList<Integer> neighbors;

		Node() {
			status = WHITE;
			neighbors = new ArrayList<>();
		}
	}

	private static HashMap<Integer, Node> graph;
	private static ArrayList<Integer> topolical_sort;

	private static void DFS(int u) {
		graph.get(u).status = GRAY;

		for (Integer i : graph.get(u).neighbors) {
			if (graph.get(i).status == WHITE)
				DFS(i);
		}

		graph.get(u).status = BLACK;
		topolical_sort.add(u);
	}

	private static void resetGraph() {
		Iterator it = graph.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			((Node) pair.getValue()).status = WHITE;
		}
	}

	private static void DFSPrint(int u) {
		graph.get(u).status = GRAY;
		System.out.print(u + " ");

		for (Integer i : graph.get(u).neighbors) {
			if (graph.get(i).status == WHITE)
				DFSPrint(i);
		}

		graph.get(u).status = BLACK;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = 0, y = 0, n_1 = n - 1, first_x = -1;

		topolical_sort = new ArrayList<>();
		graph = new HashMap<>();

		for (int i = 0; i < m; i++) {
			x = in.nextInt();
			if (first_x == -1)
				first_x = x;
			y = in.nextInt();
			if (i < n_1) {
				if (!graph.containsKey(x)) {
					Node node = new Node();
					node.neighbors = new ArrayList<>();
					node.neighbors.add(y);
					graph.put(x, node);
				} else {
					graph.get(x).neighbors.add(y);
				}

				if (!graph.containsKey(y)) {
					Node node = new Node();
					node.neighbors = new ArrayList<>();
					node.neighbors.add(x);
					graph.put(y, node);
				} else {
					graph.get(y).neighbors.add(x);
				}
			}
		}

		DFS(first_x);
		// System.out.println(topolical_sort.get(0));
		resetGraph();
		System.out.println(topolical_sort.size());
		DFSPrint(topolical_sort.get(0));
	}

}

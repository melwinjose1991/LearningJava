package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class LongestPathN2 {

	static class Pair {
		public int x, y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x, y, n_1 = n - 1, m_n_1 = m - n + 1;
		ArrayList<Pair> edges = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			x = in.nextInt();
			y = in.nextInt();
			if (i < n_1) {
				Pair pair = new Pair(x, y);
				edges.add(pair);
			}
		}

		Iterator<Pair> i = edges.iterator();
		while (i.hasNext()) {
			Pair pair = i.next();
			x = pair.x;
			y = pair.y;
			if (path.size() == 0) {
				path.add(x);
				path.add(y);
				i.remove();
			} else {
				if (x == path.getFirst()) {
					path.addFirst(y);
					i.remove();
				} else if (x == path.getLast()) {
					path.addLast(y);
					i.remove();
				} else if (y == path.getFirst()) {
					path.addFirst(x);
					i.remove();
				} else if (y == path.getLast()) {
					path.addLast(x);
					i.remove();
				}
			}
		}

		System.out.println(path.size());
		for (Integer node : path) {
			System.out.print(node + " ");
		}

	}

}

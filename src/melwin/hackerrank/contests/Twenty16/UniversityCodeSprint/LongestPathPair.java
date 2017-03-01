package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class LongestPathPair {

	static class Pair {
		public int x, y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	private static HashMap<Integer, ArrayList<Integer>> map1, map2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = 0, y = 0, temp_x, temp_y, n_1 = n - 1;
		map1 = new HashMap<>();
		map2 = new HashMap<>();

		Deque<Integer> path = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			temp_x = in.nextInt();
			temp_y = in.nextInt();
			if (i < n_1) {
				x = temp_x;
				y = temp_y;
				if (!map1.containsKey(x)) {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(y);
					map1.put(x, al);
				} else {
					map1.get(x).add(y);
				}

				if (!map2.containsKey(y)) {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(x);
					map2.put(y, al);
				} else {
					map2.get(y).add(x);
				}
			}
		}

		path.add(x);
		path.add(y);
		removeFromMap(map1, x, y);
		removeFromMap(map2, y, x);

		while (path.size() < n) {
			int head = path.getFirst();
			int tail = path.getLast();

			if (map1.containsKey(head)) {
				int new_head = getFromMap(map1, head);
				path.addFirst(new_head);
				removeFromMap(map1, head, new_head);
				removeFromMap(map2, new_head, head);
			} else if (map2.containsKey(head)) {
				int new_head = getFromMap(map2, head);
				path.addFirst(new_head);
				removeFromMap(map2, head, new_head);
				removeFromMap(map1, new_head, head);
			}

			if (map1.containsKey(tail)) {
				int new_tail = getFromMap(map1, tail);
				path.addLast(new_tail);
				removeFromMap(map1, tail, new_tail);
				removeFromMap(map2, new_tail, tail);
			} else if (map2.containsKey(tail)) {
				int new_tail = getFromMap(map2, tail);
				path.addLast(new_tail);
				removeFromMap(map2, tail, new_tail);
				removeFromMap(map1, new_tail, tail);
			}
		}

		System.out.println(path.size());
		for (Integer node : path) {
			System.out.print(node + " ");
		}

	}

	private static void removeFromMap(HashMap<Integer, ArrayList<Integer>> map, int x, int y) {
		if (map.get(x).size() == 1) {
			map.remove(x);
		} else {
			map.get(x).remove((Object) y);
		}
	}

	private static int getFromMap(HashMap<Integer, ArrayList<Integer>> map, int x) {
		return map.get(x).get(0);
	}

}

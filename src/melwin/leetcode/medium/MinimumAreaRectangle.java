package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Geometry | XXX 

public class MinimumAreaRectangle {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static int minAreaRect(int[][] points) {
		HashMap<Integer, Set<Integer>> set = new HashMap<>();
		int min_area = Integer.MAX_VALUE;
		for (int[] p : points) {
			if (!set.containsKey(p[0]))
				set.put(p[0], new HashSet<>());
			set.get(p[0]).add(p[1]);
		}

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Point a = new Point(points[i][0], points[i][1]);
				Point b = new Point(points[j][0], points[j][1]);
				if (a.y == b.y || a.x == b.x) {
					continue;
				} else {
					if (set.get(a.x).contains(b.y) && set.get(b.x).contains(a.y))
						min_area = Math.min(min_area, Math.abs(a.x - b.x) * Math.abs(a.y - b.y));
				}
			}
		}
		if (min_area != Integer.MAX_VALUE)
			return min_area;
		else
			return 0;

	}

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
		System.out.println(minAreaRect(points));
	}

}

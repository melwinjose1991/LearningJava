package melwin.leetcode;

import java.util.HashMap;

// ||LEET CODE|| ||GEOMETRY|| ||POINTS||
// ||SLOPE|| ||LINE|| ||O(n^3)||

public class Analyzed_MaxPointsOnALine {

	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				// handle duplicates and vertical
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
			// map is cleared, so parallel lines are not counted
		}

		return max;
	}

	static class Point {
		int x, y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 1);
		Point d = new Point(3, 2);

		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;

		System.out.println(maxPoints(points));
	}

}

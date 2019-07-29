package melwin.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// Heaps | Max Heap

public class KClosestPointToOrigin {
	public static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] kClosest(int[][] nums, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// System.out.println((p1.x * p1.x + p1.y * p1.y) + " - "+(p2.x * p2.x + p2.y *
				// p2.y));
				return (p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y);
			}

		});

		for (int[] n : nums) {
			if (pq.size() < k) {
				pq.add(new Point(n[0], n[1]));
			} else {
				int n_dist = n[0] * n[0] + n[1] * n[1];
				Point peek = pq.peek();
				int peek_dist = (peek.x * peek.x) + (peek.y * peek.y);
				// System.out.println(n_dist +" vs "+ peek_dist);
				if (n_dist < peek_dist) {
					pq.poll();
					pq.add(new Point(n[0], n[1]));
				}
			}
		}

		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			Point p = pq.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
			// System.out.println(p.x + " " + p.y);
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { -2, 2 } };
		kClosest(points, 1);

		points = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		kClosest(points, 2);
	}

}

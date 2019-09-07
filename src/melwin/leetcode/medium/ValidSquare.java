package melwin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// Geometry

public class ValidSquare {
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int d12 = dist(p1, p2);
		int d13 = dist(p1, p3);
		int d14 = dist(p1, p4);
		int d23 = dist(p2, p3);
		int d24 = dist(p2, p4);
		int d34 = dist(p3, p4);
		if (d12 == 0 || d13 == 0 || d14 == 0 || d23 == 0 || d24 == 0 || d34 == 0)
			return false;

		Set<Integer> unique_dist = new HashSet<>();
		unique_dist.add(d12);
		unique_dist.add(d13);
		unique_dist.add(d14);
		unique_dist.add(d23);
		unique_dist.add(d24);
		unique_dist.add(d34);
		if (unique_dist.size() == 2) {
			return true;
		} else {
			return false;
		}
	}

	private static int dist(int[] p1, int[] p2) {
		return ((p2[0] - p1[0]) * (p2[0] - p1[0])) + ((p2[1] - p1[1]) * (p2[1] - p1[1]));
	}

	public static void main(String[] args) {
	}

}

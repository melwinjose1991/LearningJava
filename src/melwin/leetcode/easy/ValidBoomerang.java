package melwin.leetcode.easy;

// Geometry

public class ValidBoomerang {

	public boolean isBoomerang(int[][] points) {
		if (!isEqual(points[0], points[1]) && !isEqual(points[1], points[2]) && !isEqual(points[0], points[2])) {
			if (getSlope(points[0], points[1]) != getSlope(points[1], points[2])) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	private boolean isEqual(int[] p1, int[] p2) {
		return p1[0] == p2[0] && p1[1] == p2[1];
	}

	private double getSlope(int[] p1, int[] p2) {
		if (p2[0] - p1[0] == 0)
			return Double.MAX_VALUE;
		return (double) (p1[1] - p2[1]) / (double) (p2[0] - p1[0]);
	}

	public static void main(String[] args) {
	}

}

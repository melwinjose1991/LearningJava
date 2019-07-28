package melwin.leetcode.easy;

// Arrays

public class RangeAdditionII {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops.length == 0)
			return m * n;
		int min_a = ops[0][0], min_b = ops[0][1];
		for (int i = 0; i < ops.length; i++) {
			min_a = Math.min(min_a, ops[i][0]);
			min_b = Math.min(min_b, ops[i][1]);
		}
		return min_a * min_b;
	}

	public static void main(String[] args) {
	}

}

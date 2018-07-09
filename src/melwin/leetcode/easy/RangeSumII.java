package melwin.leetcode.easy;

// 598 - Range Addition II

public class RangeSumII {

	public int maxCount(int m, int n, int[][] ops) {
		if (ops == null || ops.length == 0) {
			return m * n;
		}

		int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
		for (int[] op : ops) {
			row = Math.min(row, op[0]);
			col = Math.min(col, op[1]);
		}

		return row * col;
	}

	public static void main(String[] args) {
	}

}

package melwin.leetcode.medium;

// Math

public class RotateFunction {
	public static int maxRotateFunction(int[] A) {
		if (A.length == 0)
			return 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			result = Math.max(result, f(A, i));
		}
		return result;
	}

	private static int f(int[] A, int i) {
		int result = 0;
		for (int j = 0; j < A.length; j++) {
			int index = j + i;
			if (index >= A.length) {
				index = index % A.length;
			}
			result += (j * A[index]);
		}
		// System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 4, 3, 2, 6 };
		System.out.println(maxRotateFunction(A));
	}

}

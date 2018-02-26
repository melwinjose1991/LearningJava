package melwin.leetcode.medium;

// 413. Arithmetic Slices - O(n)

public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
		int curr = 0, sum = 0;
		for (int i = 2; i < A.length; i++)
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				curr += 1;
				sum += curr;
			} else {
				curr = 0;
			}
		return sum;
	}

	public static void main(String[] args) {
	}

}

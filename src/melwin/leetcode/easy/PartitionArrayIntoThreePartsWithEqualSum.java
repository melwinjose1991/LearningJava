package melwin.leetcode.easy;

// Arrays | Pre Processing

public class PartitionArrayIntoThreePartsWithEqualSum {
	public static boolean canThreePartsEqualSum(int[] A) {
		int[] back_sum = new int[A.length];
		int[] front_sum = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			back_sum[i] = (i > 0 ? back_sum[i - 1] : 0) + A[i];
			int j = A.length - i - 1;
			front_sum[j] = (j < A.length - 1 ? front_sum[j + 1] : 0) + A[j];
		}

		if (back_sum[A.length - 1] % 3 != 0)
			return false;

		for (int i = 0; i <= A.length - 3; i++) {
			if (back_sum[i] * 2 == front_sum[i + 1]) {
				for (int j = i + 1; j <= A.length - 2; j++) {
					if ((back_sum[i] == (back_sum[j] - back_sum[i]))
							&& ((back_sum[j] - back_sum[i]) == (back_sum[A.length - 1] - back_sum[j]))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] A = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
		System.out.println(canThreePartsEqualSum(A));

		A = new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 };
		System.out.println(canThreePartsEqualSum(A));

		A = new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 };
		System.out.println(canThreePartsEqualSum(A));
	}

}

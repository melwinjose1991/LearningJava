package melwin.leetcode.easy;

// Arrays

public class SortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		int even = 0, odd = 1;
		while (even < A.length && odd < A.length) {
			while (even < A.length && A[even] % 2 == 0)
				even = even + 2;
			while (odd < A.length && A[odd] % 2 == 1)
				odd = odd + 2;

			if (even < A.length && odd < A.length && A[even] % 2 == 1 && A[odd] % 2 == 0) {
				int tmp = A[even];
				A[even] = A[odd];
				A[odd] = tmp;
				even += 2;
				odd += 2;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

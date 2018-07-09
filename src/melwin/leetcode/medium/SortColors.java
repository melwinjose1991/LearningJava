package melwin.leetcode.medium;

// LEETCODE - 75 - Sort Colors - O(n)

public class SortColors {

	public void sortColors(int[] A) {

		int num0 = 0, num1 = 0, num2 = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0)
				++num0;
			else if (A[i] == 1)
				++num1;
			else if (A[i] == 2)
				++num2;
		}

		for (int i = 0; i < num0; ++i)
			A[i] = 0;
		for (int i = 0; i < num1; ++i)
			A[num0 + i] = 1;
		for (int i = 0; i < num2; ++i)
			A[num0 + num1 + i] = 2;

	}

	public static void main(String[] args) {
	}

}

package melwin.leetcode.easy;

// 27 - Remove Element - O(n)

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		int begin = 0, n = A.length;
		for (int i = 0; i < n; i++)
			if (A[i] != elem)
				A[begin++] = A[i];
		return begin;
	}

	public static void main(String[] args) {
	}

}

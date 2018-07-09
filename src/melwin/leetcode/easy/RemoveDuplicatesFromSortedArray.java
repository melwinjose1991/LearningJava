package melwin.leetcode.easy;

// 26. Remove Duplicates from Sorted Array - O(n)

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		int j = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] != A[j])
				A[++j] = A[i];
		return ++j;
	}

	public static void main(String[] args) {
	}

}

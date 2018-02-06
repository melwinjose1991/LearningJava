package melwin.leetcode.medium;

//	LEETCODE - 33 - Search in Rotated Sorted Array - O(logN)
//	Binary Search

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {

		if (A == null || A.length == 0) {
			return -1;
		}

		int lo = 0;
		int hi = A.length - 1;

		while (lo < hi) {

			int mid = (lo + hi) / 2;
			if (A[mid] == target)
				return mid;

			if (A[lo] <= A[mid]) {
				if (target >= A[lo] && target < A[mid]) {
					// low < target < mid
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (target > A[mid] && target <= A[hi]) {
					// low > mid < target <= hi
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}

		}

		return A[lo] == target ? lo : -1;
	}

	public static void main(String[] args) {
	}

}

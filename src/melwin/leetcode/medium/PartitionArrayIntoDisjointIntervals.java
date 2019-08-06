package melwin.leetcode.medium;

// Arrays | Pre Processing

public class PartitionArrayIntoDisjointIntervals {

	public static int partitionDisjoint(int[] A) {
		int[] largest = new int[A.length];
		int cur_largest = Integer.MIN_VALUE;
		int[] smallest = new int[A.length];
		int cur_smallest = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > cur_largest) {
				cur_largest = A[i];
			}
			largest[i] = cur_largest;
		}
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < cur_smallest) {
				cur_smallest = A[i];
			}
			smallest[i] = cur_smallest;
		}
		for (int i = 0; i < A.length - 1; i++) {
			if (largest[i] < smallest[i + 1]) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 0, 6, 12 };
		System.out.println(partitionDisjoint(A));

		A = new int[] { 5, 0, 3, 8, 6 };
		System.out.println(partitionDisjoint(A));

	}

}

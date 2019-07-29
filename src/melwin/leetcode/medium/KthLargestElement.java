package melwin.leetcode.medium;

import java.util.PriorityQueue;

// Heap | Min Heap

public class KthLargestElement {

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		for (int n : nums) {
			if (pq.size() < k) {
				pq.add(n);
			} else {
				if (n > pq.peek()) {
					pq.poll();
					pq.add(n);
				}
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println(findKthLargest(nums, 2));

		nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(findKthLargest(nums, 4));
	}

}

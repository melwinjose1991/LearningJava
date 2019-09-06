package melwin.leetcode.easy;

import java.util.PriorityQueue;

// Priority Queue | Min Heap

public class KthLargestElementInAStream {

	static class KthLargest {

		private PriorityQueue<Integer> pq;
		private int k;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			pq = new PriorityQueue<>(k);
			for (int i = 0; i < nums.length; i++) {
				if (i < k)
					pq.add(nums[i]);
				else {
					if (nums[i] > pq.peek()) {
						pq.poll();
						pq.add(nums[i]);
					}
				}
			}
		}

		public int add(int val) {
			if (pq.size() < k) {
				pq.add(val);
			} else {
				if (val > pq.peek()) {
					pq.poll();
					pq.add(val);
				}
			}
			return pq.peek();
		}
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 8, 2 };
		KthLargest k = new KthLargest(3, nums);
		System.out.println(k.add(3));
		System.out.println(k.add(5));
		System.out.println(k.add(10));
		System.out.println(k.add(9));
		System.out.println(k.add(4));

	}

}

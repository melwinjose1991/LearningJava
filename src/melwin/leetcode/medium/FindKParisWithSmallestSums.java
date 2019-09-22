package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKParisWithSmallestSums {
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -o1[0] + o2[0];
			}
		});

		int i = 0, j = 0;
		while (result.size() < k) {
			int sum = nums1[i] + nums2[j];
			if (pq.size() < k) {
				pq.add(new int[] { sum, i, j });
			} else {
				if (sum < pq.peek()[0]) {
					pq.poll();
					pq.add(new int[] { sum, i, j });
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
	}

}

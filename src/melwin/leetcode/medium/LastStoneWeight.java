package melwin.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// Heap | Max Heap

public class LastStoneWeight {
	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return (int) (arg1 - arg0);
			}
		});
		for (int n : stones) {
			pq.add(n);
		}

		while (pq.size() > 1) {
			int biggest_stone = pq.poll();
			int second_biggest = pq.poll();
			if (biggest_stone != second_biggest) {
				pq.add(Math.abs(biggest_stone - second_biggest));
			}
		}

		return (pq.size() == 1) ? pq.peek() : 0;
	}

	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(lastStoneWeight(stones));

		stones = new int[] { 2, 2, 1, 1 };
		System.out.println(lastStoneWeight(stones));

		stones = new int[] { 5, 4, 1 };
		System.out.println(lastStoneWeight(stones));
	}

}

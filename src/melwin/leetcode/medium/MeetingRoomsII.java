package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Intervals | XXX | Sort by start time & min-heap

public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int count = 0;
		for (int[] itv : intervals) {
			if (heap.isEmpty()) {
				count++;
				heap.offer(itv[1]);
			} else {
				if (itv[0] >= heap.peek()) {
					heap.poll();
				} else {
					count++;
				}

				heap.offer(itv[1]);
			}
		}

		return count;
	}

	public static void main(String[] args) {
	}

}

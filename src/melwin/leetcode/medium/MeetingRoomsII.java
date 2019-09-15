package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Intervals | XXX | Sort by start time & min-heap

public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max_rooms = 0;
		for (int[] intv : intervals) {
			if (pq.isEmpty()) {
				pq.offer(intv[1]);
			} else {
				while (pq.size() > 0 && intv[0] > pq.peek()) {
					pq.poll();
				}
				pq.add(intv[1]);
			}
			max_rooms = Math.max(max_rooms, pq.size());
		}
		return max_rooms;
	}

	public static void main(String[] args) {
	}

}

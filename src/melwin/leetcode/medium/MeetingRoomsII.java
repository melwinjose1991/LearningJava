package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 253 - Meeting Rooms II

public class MeetingRoomsII {

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval t1, Interval t2) {
				if (t1.start != t2.start)
					return t1.start - t2.start;
				else
					return t1.end - t2.end;
			}
		});

		int maxOverlappingMeetings = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < intervals.length; i++) {
			pq.add(intervals[i].end);
			while (pq.size() > 0 && intervals[i].start >= pq.peek())
				pq.remove();

			maxOverlappingMeetings = Math.max(maxOverlappingMeetings, pq.size());
		}

		return maxOverlappingMeetings;
	}

	public static void main(String[] args) {
	}

}

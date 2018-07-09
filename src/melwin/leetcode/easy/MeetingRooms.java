package melwin.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

import melwin.leetcode.medium.Interval;

// 252 - Meeting Rooms

public class MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
	}

}

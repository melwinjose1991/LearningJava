package melwin.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

// Interval | Scheduling | XXX

public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		if(intervals.length==0)
			return true;
		
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		int prev_end_time = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (prev_end_time > intervals[i][0]) {
				return false;
			} else {
				prev_end_time = intervals[i][1];
			}
		}
		return true;
	}

	public static void main(String[] args) {
	}

}

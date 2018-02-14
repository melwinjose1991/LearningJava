package melwin.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

import melwin.leetcode.medium.Interval;

// 57 - Insert Interval - O(n)

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new LinkedList<>();
		int i = 0;

		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}

		result.add(newInterval); // add the union of intervals we got

		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));

		return result;
	}

	public static void main(String[] args) {
	}

}

package melwin.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

// 295 - Find Median from Data Stream - O(logN), O(1)

public class FindMedianFromDataStream {

	PriorityQueue<Integer> min, max;

	public FindMedianFromDataStream() {
		min = new PriorityQueue<Integer>();
		max = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public void addNum(int num) {
		max.offer(num);
		min.offer(max.poll());
		if (max.size() < min.size()) {
			max.offer(min.poll());
		}
	}

	public double findMedian() {
		if (max.size() == min.size())
			return (max.peek() + min.peek()) / 2.0;
		else
			return max.peek();
	}

	public static void main(String[] args) {
	}

}

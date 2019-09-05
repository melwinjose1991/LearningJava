package melwin.leetcode.medium;

import java.util.LinkedList;

// LinkedList

public class DesignHitCounter {
	static class HitCounter {

		private LinkedList<Integer> list;
		private final int TIME_WINDOW = 300;

		public HitCounter() {
			list = new LinkedList<>();
		}

		public void hit(int timestamp) {
			list.add(timestamp);
			while (list.size() > 0 && list.peekFirst() <= timestamp - TIME_WINDOW) {
				list.removeFirst();
			}
		}

		public int getHits(int timestamp) {
			while (list.size() > 0 && list.peekFirst() <= timestamp - TIME_WINDOW) {
				list.removeFirst();
			}
			return list.size();
		}
	}

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		System.out.println(counter.getHits(4));
		counter.hit(300);
		System.out.println(counter.getHits(300));
		System.out.println(counter.getHits(301));
	}

}

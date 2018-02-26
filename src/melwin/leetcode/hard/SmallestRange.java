package melwin.leetcode.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 632 - Smallest Range - O(logK * n) - keep evaluating range of smallest from each list

public class SmallestRange {

	public int[] smallestRange(List<List<Integer>> nums) {

		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		});

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Element e = new Element(i, 0, nums.get(i).get(0));
			pq.offer(e);
			max = Math.max(max, nums.get(i).get(0));
		}

		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.size()) {

			Element curr = pq.poll();
			if (max - curr.val < range) {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}
			if (curr.idx + 1 < nums.get(curr.row).size()) {
				curr.idx = curr.idx + 1;
				curr.val = nums.get(curr.row).get(curr.idx);
				pq.offer(curr);
				if (curr.val > max) {
					max = curr.val;
				}
			}
		}

		return new int[] { start, end };

	}

	class Element {
		int val;
		int idx;
		int row;

		public Element(int r, int i, int v) {
			val = v;
			idx = i;
			row = r;
		}
	}

	public static void main(String[] args) {
	}

}

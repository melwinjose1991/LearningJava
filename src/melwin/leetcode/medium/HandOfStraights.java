package melwin.leetcode.medium;

import java.util.Map.Entry;
import java.util.TreeMap;

// Tree Map | XXX

public class HandOfStraights {
	public static boolean isNStraightHand(int[] hand, int W) {
		if (hand.length % W != 0)
			return false;

		TreeMap<Integer, Integer> card_count = new TreeMap<>();
		for (int h : hand) {
			card_count.put(h, card_count.getOrDefault(h, 0) + 1);
		}

		for (Entry<Integer, Integer> entry : card_count.entrySet()) {
			int h = entry.getKey();
			int count = entry.getValue();
			if (count > 0) {
				card_count.put(h, 0);
				for (int i = 1; i < W; i++) {
					int next_h = h + i;
					if (card_count.containsKey(next_h) && card_count.get(next_h) >= count) {
						int next_h_count = card_count.get(next_h);
						card_count.put(next_h, next_h_count - count);
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		System.out.println(isNStraightHand(hand, 3));

		hand = new int[] { 1, 1, 2, 2, 3, 3 };
		System.out.println(isNStraightHand(hand, 3));
	}

}

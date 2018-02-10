package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 767 - Reorganize String - O(n.log2(26)) - use heap & use most frequent element as much as possible

public class ReorganizeString {

	public String reorganizeString(String S) {

		Map<Character, Integer> map = new HashMap<>();
		for (char c : S.toCharArray()) {
			int count = map.getOrDefault(c, 0) + 1;
			if (count > (S.length() + 1) / 2)
				return "";
			map.put(c, count);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (char c : map.keySet()) {
			pq.add(new int[] { c, map.get(c) });
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int[] first = pq.poll();
			if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
				sb.append((char) first[0]);
				if (--first[1] > 0) {
					pq.add(first);
				}
			} else {
				int[] second = pq.poll();
				sb.append((char) second[0]);
				if (--second[1] > 0) {
					pq.add(second);
				}
				pq.add(first);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
	}

}

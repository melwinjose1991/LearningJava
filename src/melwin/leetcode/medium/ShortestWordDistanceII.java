package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 244 - Shortest Word Distance II - O(n)

public class ShortestWordDistanceII {

	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public ShortestWordDistanceII(String[] words) {

		for (int i = 0; i < words.length; i++) {
			String curWord = words[i];
			if (map.containsKey(curWord)) {
				map.get(curWord).add(i);
			} else {
				List<Integer> list = map.get(curWord);
				list.add(i);
				map.put(curWord, list);
			}

		}
	}

	public int shortestDistance(String word1, String word2) {
		List<Integer> indexList1 = map.get(word1);
		List<Integer> indexList2 = map.get(word2);
		int minDistance = Integer.MAX_VALUE;
		int p1 = 0, p2 = 0;

		while (p1 < indexList1.size() && p2 < indexList2.size()) {
			int idx1 = indexList1.get(p1);
			int idx2 = indexList2.get(p2);
			minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
			if (idx1 < idx2)
				p1++;
			else
				p2++;
		}

		return minDistance;
	}

	public static void main(String[] args) {
	}

}

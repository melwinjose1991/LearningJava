package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// Strings | Sliding Window

public class PositionOfLargeGroups {
	public static List<List<Integer>> largeGroupPositions(String S) {
		char c = '0';
		int count = 0, start = -1;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < S.length(); i++) {
			if (i == 0) {
				c = S.charAt(i);
				count = 1;
				start = i;
			} else {
				if (c == S.charAt(i)) {
					count++;
				} else {
					if (count >= 3) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(start);
						tmp.add(i - 1);
						results.add(tmp);
					}
					start = i;
					count = 1;
				}
			}
			c = S.charAt(i);
		}
		if (count >= 3) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(start);
			tmp.add(S.length() - 1);
			results.add(tmp);
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));

	}

}

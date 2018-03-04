package melwin.leetcode.medium;

import java.util.Arrays;

// 277 - Find Celebrity - candidate list

public class FindCelebrity {

	public static int findCelebrity(int n) {
		boolean[] candidate = new boolean[n];
		Arrays.fill(candidate, true);

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (candidate[i] && i != j) {
					if (knows(i, j) || !knows(j, i)) {
						candidate[i] = false;
						break;
					} else {
						candidate[j] = false;
					}
				}
			}
			if (candidate[i])
				return i;
		}
		return -1;
	}

	public static boolean knows(int i, int j) {
		return true;
	}

	public static void main(String[] args) {
	}

}

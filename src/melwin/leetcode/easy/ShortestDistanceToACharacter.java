package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Pre processing

public class ShortestDistanceToACharacter {
	public static int[] shortestToChar(String S, char C) {
		int dist = Integer.MAX_VALUE;
		int[] result = new int[S.length()];
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == C) {
				dist = i;
				result[i] = 0;
			} else {
				result[i] = (dist == Integer.MAX_VALUE) ? dist : i - dist;
			}
		}
		dist = Integer.MAX_VALUE;
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == C) {
				dist = i;
				result[i] = 0;
			} else {
				result[i] = Math.min(result[i], (dist == Integer.MAX_VALUE) ? dist : dist - i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
	}

}

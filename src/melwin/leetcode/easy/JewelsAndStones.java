package melwin.leetcode.easy;

import java.util.HashSet;

// Hash Set

public class JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
		HashSet<Character> jewels = new HashSet<>();
		for (char j : J.toCharArray()) {
			jewels.add(j);
		}
		int count = 0;
		for (char s : S.toCharArray()) {
			if (jewels.contains(s)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
	}

}

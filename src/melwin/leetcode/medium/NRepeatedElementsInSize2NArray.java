package melwin.leetcode.medium;

import java.util.HashSet;

// Arrays | HashSet | Medium

public class NRepeatedElementsInSize2NArray {
	public int repeatedNTimes(int[] A) {
		HashSet<Integer> set = new HashSet<>();
		for (int a : A) {
			if (!set.add(a)) {
				return a;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
	}
}

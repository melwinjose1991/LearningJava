package melwin.leetcode.easy;

// Bit Manipulation

public class FindTheDifference {
	public static char findTheDifference(String s, String t) {
		char result = 0;
		for (char c : s.toCharArray()) {
			result ^= c;
		}
		for (char c : t.toCharArray()) {
			result ^= c;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
	}

}

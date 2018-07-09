package melwin.leetcode.medium;

// Leetcode - 44 - Wildcard Matching - O(p.s)
// Pointer Technique - Keep track of idx where last * was matched

public class WildcardMatching {

	public boolean isMatch(String str, String pattern) {

		// match : last char matched using *
		int s = 0, p = 0, match = 0, starIdx = -1;

		while (s < str.length()) {

			// advancing both pointers
			if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
				s++;
				p++;
			}

			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}

			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}

			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	public static void main(String[] args) {
	}

}

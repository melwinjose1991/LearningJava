package melwin.leetcode.easy;

// Strings

public class ValidPalindromeII {
	public static boolean validPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i <= j;) {
			if (s.charAt(i) != s.charAt(j)) {
				String s1 = s.substring(0, i) + s.substring(i + 1, s.length());
				String s2 = s.substring(0, j) + s.substring(j + 1, s.length());
				StringBuilder s1_rev = new StringBuilder(s1);
				StringBuilder s2_rev = new StringBuilder(s2);
				return s1.equals(s1_rev.reverse().toString()) || s2.equals(s2_rev.reverse().toString());
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abca"));
		System.out.println(validPalindrome("a"));
		System.out.println(validPalindrome("aa"));
		System.out.println(validPalindrome("abcdca"));
		
		System.out.println(validPalindrome("abdca"));
		System.out.println(validPalindrome("abc"));
	}

}

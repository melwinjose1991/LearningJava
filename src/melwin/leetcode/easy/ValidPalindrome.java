package melwin.leetcode.easy;

// Strings

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			while (i < s.length() && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)))
				i++;
			while (j >= 0 && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j)))
				j--;
			if (i <= j) {
				if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
					return false;
				else {
					i++;
					j--;
				}
			} else {
				break;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("a b a"));
		System.out.println(isPalindrome("121"));
		System.out.println(isPalindrome(" 1 a 2 a 1 "));

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));

	}

}

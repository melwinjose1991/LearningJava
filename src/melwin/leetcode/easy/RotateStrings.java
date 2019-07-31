package melwin.leetcode.easy;

// Strings | Easy

public class RotateStrings {
	public static boolean rotateString(String A, String B) {
		if (A.length() != B.length())
			return false;
		String b_x2 = B + "" + B;
		return b_x2.contains(A);
	}

	public static void main(String[] args) {
		System.out.println(rotateString("abc", "cabcab"));
		System.out.println(rotateString("abc", "abc"));
		System.out.println(rotateString("abcde", "cdeab"));

		System.out.println(rotateString("abcde", "abced"));
		System.out.println(rotateString("abc", "acbacb"));
	}

}

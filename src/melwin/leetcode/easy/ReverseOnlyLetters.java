package melwin.leetcode.easy;

public class ReverseOnlyLetters {

	public static String reverseOnlyLetters(String S) {
		char[] S_rev = new char[S.length()];
		for (int i = 0; i < S.length(); i++) {
			if (!Character.isLetter(S.charAt(i))) {
				S_rev[i] = S.charAt(i);
			} else {
				S_rev[i] = 'x';
			}
		}
		for (int i = 0, j = S.length() - 1; i < S.length(); i++) {
			if (Character.isLetter(S.charAt(i))) {
				while (!Character.isLetter(S_rev[j]))
					j--;
				S_rev[j] = S.charAt(i);
				j--;
			}
		}
		return new String(S_rev);
	}

	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("ab-cd"));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
		
		System.out.println(reverseOnlyLetters("a11b22c33d"));
	}

}

package melwin.leetcode.easy;

public class StrobogrammaticNumber {
	public static boolean isStrobogrammatic(String num) {
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			if (!isEqual(num.charAt(i), num.charAt(j))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isEqual(char x, char y) {
		switch (x) {
		case '0':
			return y == '0';
		case '1':
			return y == '1';
		case '8':
			return y == '8';
		case '6':
			return y == '9';
		case '9':
			return y == '6';
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
	}

}

package melwin.leetcode.easy;

// Strings

public class GCDofStrings {
	public static String gcdOfStrings(String str1, String str2) {
		String s_s = (str1.length() <= str2.length()) ? str1 : str2;
		String l_s = (str1.length() > str2.length()) ? str1 : str2;
		int max_x_len = 0;
		String X = "";
		for (int i = 0; i < s_s.length(); i++) {
			if ((s_s.length() % (i + 1)) == 0 && (l_s.length() % (i + 1)) == 0) {
				String x = s_s.substring(0, i + 1);
				if (isDividable(x, s_s) && isDividable(x, l_s) && x.length() > max_x_len) {
					X = x;
					max_x_len = x.length();
				}
			}
		}
		return X;
	}

	public static boolean isDividable(String shorter_str, String longer_str) {
		int count = longer_str.length() / shorter_str.length();

		for (int i = 0; i < count; i++) {
			if (!longer_str.substring(i * shorter_str.length(), (i * shorter_str.length()) + shorter_str.length())
					.equals(shorter_str)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isDividable("ABC", "ABCABC"));
		System.out.println(isDividable("AB", "ABCABC"));
		System.out.println(isDividable("AB", "AB"));
	}

}

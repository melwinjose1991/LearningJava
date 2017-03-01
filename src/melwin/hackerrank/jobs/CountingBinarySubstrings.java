package melwin.hackerrank.jobs;

public class CountingBinarySubstrings {

	static int count(String s) {
		int count = 0, n = s.length();
		for (int i = 0; i < s.length() - 1; i++) {
			if ((s.charAt(i) == '0' && s.charAt(i + 1) == '1') || (s.charAt(i) == '1' && s.charAt(i + 1) == '0')) {
				count++;
				int left = i - 1;
				int right = i + 2;
				char left_char = s.charAt(i);
				char right_char = s.charAt(i + 1);
				while (left >= 0 && right <= n - 1 && (s.charAt(left) == left_char && s.charAt(right) == right_char)) {
					count++;
					left--;
					right++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count("10001"));
	}

}

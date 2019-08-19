package melwin.leetcode.easy;

// Arrays | 

public class StringCompression {
	public static int compress(char[] chars) {
		if (chars.length == 1)
			return 1;

		int write_index = 0;
		for (int i = 0; i < chars.length;) {
			int j = i;
			while (j + 1 < chars.length && chars[i] == chars[j + 1])
				j++;
			if (i == j) {
				if (write_index < chars.length)
					chars[write_index] = chars[i];
				write_index++;
				i++;
			} else {
				int count = j - i + 1;
				String count_str = String.valueOf(count);
				if (write_index < chars.length)
					chars[write_index] = chars[i];
				write_index++;
				for (int k = 0; k < count_str.length(); k++) {
					if (write_index < chars.length)
						chars[write_index] = count_str.charAt(k);
					write_index++;
				}
				i = j + 1;
			}
		}
		return write_index;
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println(compress(chars));

		chars = new char[] { 'a', 'a', 'a', 'a' };
		System.out.println(compress(chars));

		chars = new char[] { 'a' };
		System.out.println(compress(chars));

		chars = new char[] { 'a', 'b', 'c' };
		System.out.println(compress(chars));
	}

}

package melwin.leetcode.easy;

// String

public class DesignCompressedStringIterator {

	private String str;
	private char c;
	private int count, i;

	public DesignCompressedStringIterator(String compressedString) {
		this.str = compressedString;
		i = 0;
		count = 0;
	}

	public char next() {
		if (count > 0) {
			count--;
			return c;
		} else {
			if (i < str.length()) {
				c = str.charAt(i++);
				StringBuilder count_str = new StringBuilder();
				while (i < str.length() && Character.isDigit(str.charAt(i))) {
					count_str.append(str.charAt(i++));
				}
				count = Integer.parseInt(count_str.toString());
				count--;
				return c;
			} else {
				return ' ';
			}
		}
	}

	public boolean hasNext() {
		return count > 0 || i < str.length();
	}

	public static void main(String[] args) {
		DesignCompressedStringIterator obj = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
	}

}

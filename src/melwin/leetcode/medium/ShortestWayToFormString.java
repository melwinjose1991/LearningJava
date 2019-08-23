package melwin.leetcode.medium;

// String | Subsequence

public class ShortestWayToFormString {
	public static int shortestWay(String source, String target) {
		int count = 0, j = 0;
		for (int i = 0; i < target.length();) {
			int i_start = i;
			j = 0;
			while (j < source.length() && i < target.length()) {
				if (source.charAt(j) == target.charAt(i)) {
					i++;
					j++;
				} else {
					j++;
				}
			}
			if (i == i_start)
				return -1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(shortestWay("abc", "abcbc"));
		System.out.println(shortestWay("abc", "acdbc"));
		System.out.println(shortestWay("xyz", "xyzxyz"));
		System.out.println(shortestWay("xyz", "xzyxz"));
	}

}

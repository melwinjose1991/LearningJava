package melwin.leetcode.easy;

public class DefangingAnIPAddress {
	public static String defangIPaddr(String address) {
		StringBuilder result = new StringBuilder();
		for (char c : address.toCharArray()) {
			if (c == '.') {
				result.append("[.]");
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.2.3.4"));
	}

}

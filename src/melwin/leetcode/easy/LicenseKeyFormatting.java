package melwin.leetcode.easy;

// Strings

public class LicenseKeyFormatting {
	public static String licenseKeyFormatting(String s, int k) {
		StringBuilder result = new StringBuilder();
		for (int i = s.length() - 1; i >= 0;) {
			int count = 0, j = i;
			while (j >= 0 && count < k) {
				char c = s.charAt(j);
				if (c != '-') {
					result.append(result.length() > 0 && count == 0 ? "-" : "");
					char new_c = Character.isDigit(c) ? c : Character.toUpperCase(c);
					result.append(new_c);
					count++;
				}
				j--;
			}
			i = j;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
		System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
		System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
	}

}

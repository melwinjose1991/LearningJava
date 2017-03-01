package melwin.leetcode;

public class Analyzed_ReverseWordsInAString {

	public String reverseWords(String s) {
		StringBuilder ret = new StringBuilder(s.length());
		for (int i = s.length() - 1; i >= 0;) {
			if (s.charAt(i) == ' ')
				i--;
			else {
				int end_index = i;
				while (i >= 0 && s.charAt(i) != ' ') {
					i--;
				}
				int start_index = i + 1;
				ret.append(s.substring(start_index, end_index+1)+" ");
			}
		}
		if(ret.length()>0) ret.deleteCharAt(ret.length()-1);
		return ret.toString();
	}

	public static void main(String[] args) {
		Analyzed_ReverseWordsInAString x = new Analyzed_ReverseWordsInAString();
		System.out.println(x.reverseWords(" the sky is blue "));
		System.out.println(x.reverseWords(" "));
		System.out.println(x.reverseWords(""));
		System.out.println(x.reverseWords(" the  sky   is  blue "));
		System.out.println(x.reverseWords("a "));
	}

}

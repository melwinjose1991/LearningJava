package melwin.leetcode.medium;

import java.util.Stack;

// Stack

public class DecodeString {
	public static String decodeString(String s) {
		Stack<String> stack_str = new Stack<>();
		Stack<Integer> stack_count = new Stack<>();
		String result = "";
		for (int i = 0; i < s.length();) {
			if (Character.isDigit(s.charAt(i))) {
				StringBuilder count_str = new StringBuilder();
				while (Character.isDigit(s.charAt(i))) {
					count_str.append(s.charAt(i));
					i++;
				}
				stack_count.push(Integer.parseInt(count_str.toString()));
				if (Character.isDigit(s.charAt(i + 1))) {
					stack_str.push("");
				}
			} else if (Character.isLetter(s.charAt(i))) {
				StringBuilder seq_str = new StringBuilder();
				while (i < s.length() && Character.isLetter(s.charAt(i))) {
					seq_str.append(s.charAt(i));
					i++;
				}
				if (stack_count.size() > stack_str.size())
					stack_str.push(seq_str.toString());
				else {
					if (stack_str.size() == 0) {
						result += seq_str;
					} else {
						String top = stack_str.pop();
						stack_str.push(top + seq_str);
					}
				}
			} else if (s.charAt(i) == ']') {
				StringBuilder repeated_str = new StringBuilder(stack_str.peek());
				int count = stack_count.pop();
				for (int j = 1; j < count; j++) {
					repeated_str.append(stack_str.peek());
				}
				stack_str.pop();
				if (stack_str.size() > 0) {
					String top = stack_str.pop();
					stack_str.push(top + repeated_str);
				} else {
					result += repeated_str;
				}
				i++;
			} else {
				i++;
			}
		}
		return result + (stack_str.size() > 0 ? stack_str.pop() : "");
	}

	public static void main(String[] args) {
		System.out.println(decodeString("a2[2[b]]c"));
		System.out.println(decodeString("2[b4[F]c]"));

		System.out.println(decodeString("1[a]2[b]3[c]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}

}

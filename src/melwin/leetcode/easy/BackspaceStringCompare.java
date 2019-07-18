package melwin.leetcode.easy;

import java.util.Stack;

// Stack

public class BackspaceStringCompare {

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> s_stack = new Stack<Character>();
		Stack<Character> t_stack = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (s_stack.size() > 0) {
					s_stack.pop();
				}
			} else {
				s_stack.push(S.charAt(i));
			}
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#') {
				if (t_stack.size() > 0) {
					t_stack.pop();
				}
			} else {
				t_stack.push(T.charAt(i));
			}
		}
		if(s_stack.equals(t_stack)) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab", "ab"));
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));

		System.out.println(backspaceCompare("a#c", "b"));
		System.out.println(backspaceCompare("da#", "aa#"));
	}

}

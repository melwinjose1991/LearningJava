package melwin.leetcode.easy;

import java.util.Stack;

// Stack

public class ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case ')':
				if (stack.size() > 0 && stack.peek() == '(')
					stack.pop();
				else
					return false;
				break;
			case ']':
				if (stack.size() > 0 && stack.peek() == '[')
					stack.pop();
				else
					return false;
				break;
			case '}':
				if (stack.size() > 0 && stack.peek() == '{')
					stack.pop();
				else
					return false;
				break;
			default:
				stack.push(s.charAt(i));
				break;
			}
		}
		if(stack.size()==0) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("([{}])"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()()()"));
		
		System.out.println(isValid("((())"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("())"));
		System.out.println(isValid("([)]"));
	}

}

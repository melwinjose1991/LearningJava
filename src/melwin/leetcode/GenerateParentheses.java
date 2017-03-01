package melwin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	private void generateAllValidParanthesis(String s, int left, int right, List<String> sol) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			sol.add(s);
			return;
		}

		if (left > 0) {
			generateAllValidParanthesis(s + "(", left - 1, right, sol);
		}

		if (right > 0) {
			generateAllValidParanthesis(s + ")", left, right - 1, sol);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> sol = new ArrayList<>();
		generateAllValidParanthesis("", n, n, sol);
		return sol;
	}

	public static void main(String[] args) {
		GenerateParentheses x = new GenerateParentheses();
		System.out.println(x.generateParenthesis(3));
	}

}

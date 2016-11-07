package melwin.hackerrank.contests.Twenty16.NCRCodeSprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SuperValidBracketSequences {

	private static int n, k;

	private static ArrayList<HashSet<String>> strings_of_size_n;
	private static HashMap<String, Integer> solution;

	private static boolean isSuperValid(String s) {
		int count = 0;
		for (int i = 0; i <= s.length() - 2; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				count += 1;
		}
		if (count >= k)
			return true;
		else
			return false;
	}

	private static void generateAllValidParanthesis(String s, int left, int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			strings_of_size_n.get(n / 2).add(s);
			return;
		}

		if (left > 0) {
			generateAllValidParanthesis(s + "(", left - 1, right);
		}

		if (right > 0) {
			generateAllValidParanthesis(s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		solution = new HashMap<>();
		strings_of_size_n = new ArrayList<>(101); // index : 1-100
		for (int i = 0; i <= 100; i++) {
			strings_of_size_n.add(new HashSet<>());
		}

		Scanner in = new Scanner(System.in);
		int q = Integer.parseInt(in.nextLine());

		for (int i = 1; i <= q; i++) {
			String input = in.nextLine();
			n = Integer.parseInt(input.split(" ")[0]);
			k = Integer.parseInt(input.split(" ")[1]);
			if (n % 2 != 0) {
				// invalid no of parenthesis
				System.out.println("0");
			} else {
				if (strings_of_size_n.get(n / 2).size() == 0){
					//System.out.println("generating");
					generateAllValidParanthesis("", n / 2, n / 2);
				}
				// System.out.println(strings_of_size_n.get(n/2).toString());
				int count = 0;
				if (!solution.containsKey(n+"|"+k)) {
					//System.out.println("counting");
					for (String s : strings_of_size_n.get(n / 2)) {
						if (isSuperValid(s))
							count++;
					}
					solution.put(n+"|"+k, count);
				} else {
					count = solution.get(n+"|"+k);
				}
				System.out.println(count);
			}
		}

	}

}

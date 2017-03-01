package melwin.hackerrank.practice.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ||NEXT_LEXICON|| ||NEXT_GREATEST_NUMBER|| ||NEXT_PERMUTATION||
 */

public class BiggerIsGreater {

	private static int n;
	private static Scanner in = new Scanner(System.in);

	private static String nextLexicon(String input) {
		int i = 0;
		for (i = input.length() - 1; i > 0; i--) {
			if (input.charAt(i - 1) < input.charAt(i)) {
				break;
			}
		}
		if (i == 0)
			return "no answer";

		int smallest_index = i - 1;
		char smallest = input.charAt(smallest_index);

		int next_smallest_index = i;
		char next_smallest = input.charAt(i);
		for (int j = i + 1; j < input.length(); j++) {
			if (input.charAt(j) > smallest && input.charAt(j) < next_smallest) {
				next_smallest_index = j;
				next_smallest = input.charAt(next_smallest_index);
			}
		}

		char[] char_array = input.toCharArray();
		char temp = char_array[smallest_index];
		char_array[smallest_index] = char_array[next_smallest_index];
		char_array[next_smallest_index] = temp;

		Arrays.sort(char_array, smallest_index + 1, input.length());

		return String.valueOf(char_array);
	}

	public static void main(String[] args) {
		n = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			System.out.println(nextLexicon(s));
		}
	}

}

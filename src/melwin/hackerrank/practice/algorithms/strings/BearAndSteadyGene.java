package melwin.hackerrank.practice.algorithms.strings;

import java.util.HashMap;
import java.util.Scanner;

/*
 * ||TWO_POINTER|| ||SMALLEST_WINDOW_WITH_GIVEN_CHARACTERS||
 */

public class BearAndSteadyGene {

	private static int n;
	private static Scanner in = new Scanner(System.in);
	private static HashMap<Character, Integer> char_map;
	private static int[] char_count = new int[4];

	private static boolean countACTGandSteady(String s) {
		char_map = new HashMap<>();
		char_map.put('A', 0);
		char_map.put('C', 1);
		char_map.put('T', 2);
		char_map.put('G', 3);
		for (int i = 0; i < n; i++) {
			char_count[char_map.get(s.charAt(i))]++;
		}
		return checkSteady();
	}

	private static boolean checkSteady() {
		for (int i = 0; i < 4; i++) {
			if (char_count[i] > n / 4)
				return false;
		}
		return true;
	}

	private static void findSmallestWindow(String s) {
		int min_length = s.length();
		for (int i = 0, j = 0; i < s.length(); i++) {
			for (; j < s.length() && !checkSteady(); j++)
				char_count[char_map.get(s.charAt(j))]--;
			if (checkSteady())
				min_length = Math.min(min_length, j - i);
			char_count[char_map.get(s.charAt(i))]++;
		}

		System.out.println(min_length);
	}

	public static void main(String[] args) {
		n = Integer.parseInt(in.nextLine().trim());
		String input = in.nextLine();
		if (!countACTGandSteady(input))
			findSmallestWindow(input);
		else
			System.out.println("0");
	}

}

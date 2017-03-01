package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * ||MAXIMUM_INTERVAL_OVERLAP|| ||geeksforgeeks||
 */

public class KindergartenAdventures {

	private static int findMaxItemsIndex(ArrayList<Integer> start, ArrayList<Integer> end) {
		Collections.sort(start);
		Collections.sort(end);

		int items_in = 1, max_items = 1, index = start.get(0);
		int i = 1, j = 0, n = start.size();

		while (i < n && j < n) {
			if (start.get(i) <= end.get(j)) {
				items_in++;

				if (items_in > max_items) {
					max_items = items_in;
					index = start.get(i);
				}
				i++;
			} else {
				items_in--;
				j++;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] t = new int[n];

		ArrayList<Integer> start = new ArrayList<>(n * 2);
		ArrayList<Integer> end = new ArrayList<>(n * 2);
		int start_index, end_index;

		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
			if (t[i] == 0 || t[i] == n)
				continue;
			start_index = i - t[i];
			end_index = i + 1;
			if (start_index < 0) {
				start_index = n + start_index;
			}
			if (end_index == n) {
				end_index = 0;
			}
			if (start_index >= end_index) {
				start.add(end_index);
				end.add(start_index);
			} else {
				start.add(0);
				end.add(start_index);

				start.add(end_index);
				end.add(n - 1);
			}

		}

		if (start.size() == 0)
			System.out.println("1");
		else
			System.out.println(findMaxItemsIndex(start, end) + 1);

	}

}

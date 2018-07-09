package melwin.codinginterview.SortingAndSearching;

import java.util.Arrays;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 7	:	Peaks and Valleys
 * 
 * TAGS : ||CRACKING|| ||NEW_TECHNIQUE|| 
 */

public class PeaksAndValleys {

	private static int[] array = { 5, 1, 3, 2, 3 };

	private static void sort() {
		for (int i = 1; i < array.length; i += 2) {
			int index = indexOfMin(i - 1, i, i + 1);
			if (i != index) {
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
	}

	private static int indexOfMin(int a, int b, int c) {
		int len = array.length;
		int aValue = a >= 0 && a < len ? array[a] : Integer.MAX_VALUE;
		int bValue = b >= 0 && b < len ? array[b] : Integer.MAX_VALUE;
		int cValue = c >= 0 && c < len ? array[c] : Integer.MAX_VALUE;

		int min = Math.min(aValue, Math.min(bValue, cValue));
		if (aValue == min)
			return a;
		else if (bValue == min)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		sort();

		// ||NEW_TECHNIQUE||
		System.out.println(Arrays.toString(array));
	}

}

package melwin.codinginterview.SortingAndSearching;

import java.util.BitSet;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 8	:	Find Duplicates
 * 
 * TAGS : ||NEW_TECHNIQUE|| ||BITSET|| ||CRACKING||
 */

public class FindDuplicates {

	// boolean[] v BitSet
	// http://chrononsystems.com/blog/hidden-evils-of-javas-byte-array-byte
	private static BitSet bs;

	private static int[] inputs = { 1, 2, 3, 4, 5, 6, 6, 7 };

	public static void main(String[] args) {
		bs = new BitSet(32000);

		for (int n : inputs) {
			int n0 = n - 1;
			if (bs.get(n0))
				System.out.println(n);
			else
				bs.set(n0);
		}
	}
}

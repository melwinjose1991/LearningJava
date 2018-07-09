package melwin.codinginterview.SortingAndSearching;

import java.util.Arrays;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 1	:	SortedMerge
 * 
 * TAGS : ||NEW_TECHNIQUE|| ||MERGE_SORT|| ||CRACKING||
 */

public class SortedMerge {

	private static void sortedMerge(int A[], int B[]) {
		int k = A.length - 1;
		int a_i = 0, b_i = B.length - 1;

		// finding the index of the last element in A
		for (int j = A.length - 1; j >= 0; j--) {
			if (A[j] != -1) {
				a_i = j;
				break;
			}
		}
		System.out.println(" a_i:" + a_i + "\tb_i:" + b_i + "\tk:" + k);

		// ||MERGE_SORT||
		while (a_i >= 0 && b_i >= 0) {
			if (A[a_i] > B[b_i]) {
				A[k--] = A[a_i--];
			} else {
				A[k--] = B[b_i--];
			}
		}
		while (a_i >= 0) {
			A[k--] = A[a_i--];
		}
		while (b_i >= 0) {
			A[k--] = B[b_i--];
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 7, -1, -1, -1, -1 };
		int B[] = { 2, 4, 6, 8 };

		// ||NEW_TECHNIQUE||
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));

		sortedMerge(A, B);

		System.out.println(Arrays.toString(A));
	}

}

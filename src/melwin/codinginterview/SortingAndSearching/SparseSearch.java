package melwin.codinginterview.SortingAndSearching;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 5	:	SparseSearch
 * 
 * TAGS : ||BINARY_SEARCH|| ||CRACKING||
 */

public class SparseSearch {

	private static String find;

	private static boolean binarySearch(String[] input, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		while ((mid <= end) && input[mid].equals("")) {
			mid++;
		}
		if (mid > end) {
			mid = (start + end) / 2;
			while ((mid >= start) && input[mid].equals("")) {
				mid--;
			}
			if (mid < start) {
				return false;
			}
		}
		if (input[mid].equals(find))
			return true;
		int compare = input[mid].compareTo(find);
		if (compare < 0) {
			return binarySearch(input, mid + 1, end);
		} else {
			return binarySearch(input, start, mid - 1);
		}
	}

	public static void main(String[] args) {
		String[] input = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "elf" };

		for (String s : input) {
			if (s.length() == 0)
				continue;
			find = s;
			if (binarySearch(input, 0, input.length - 1))
				System.out.println("FOUND");
		}
	}

}

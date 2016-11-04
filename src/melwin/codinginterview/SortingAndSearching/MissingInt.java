package melwin.codinginterview.SortingAndSearching;

/*
 * Chapter 10 	: 	Sorting and Searching
 * Question 7	:	Missing Int
 * 
 * TAGS : ||NEW_TECHNIQUE|| ||BINARY|| ||CRACKING||
 */


public class MissingInt {
	private static byte[] bitfield = new byte[2];
	private static int[] inputs = { 0, 1, 2, 3, 4, 5, 6, 8, 9, 10 };

	private static void setBits() {
		for (int n : inputs) {
			bitfield[n / 8] |= (1 << (n % 8));
		}
	}

	private static int findMissing() {
		for (int i = 0; i < bitfield.length; i++) {
			byte b = bitfield[i];
			for (int j = 0; j < 8; j++) {
				if ((b & (1 << j)) == 0) {
					return ((i*8)+j) > inputs[inputs.length-1] ? -1 : ((i*8)+j);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		setBits();
		System.out.println(findMissing());
	}

}

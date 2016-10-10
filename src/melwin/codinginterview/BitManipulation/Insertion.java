package melwin.codinginterview.BitManipulation;

/*
 * Chapter 	5 : Bit Manipulation
 * Question 1 : Insertion
 * 
 * Negative Numbers
 * 		The binary representation of-K (negative K) as a N-bit number :
 * 			1) concat ( 1, 2^(N -1) - K)
 * 			2) invert bits in positive representation and add 1
 * 
 * Arithmetic v Logical Shifts
 * 		logical right shift >>> shift the bits and put a 0 in the most significant bit.
 *  	arithmetic right shift >> shift values to the right but fill in the new bits 
 *  								with the value of the sign bit
 *  
 *  GetBit, SetBit, ClearBit, UpdateBit
 *  
 *  -1 = 111...111
 */
public class Insertion {

	private static void printBinary(int n) {
		for (int i = 31; i >= 0; i--) {
			if ((n & (1 << i)) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int M = 2, N = 65;
		int i = 2, j=4;

		printBinary(N);
		printBinary(M);

		int term_0 = (-1 << j);
		printBinary(term_0);
		
		int term_1 = term_0 & N;
		printBinary(term_1);
		
		int term_2 = (-1 >>> 32-i);
		printBinary(term_2);
		
		int term_3 = term_2 & N;
		printBinary(term_3);
		
		int term_4 = term_1 ^ term_3;
		printBinary(term_4);
		
		int term_5 = M << i ;
		printBinary(term_5);
		
		int ans = term_4 ^ term_5;
		printBinary(ans);
	}

}

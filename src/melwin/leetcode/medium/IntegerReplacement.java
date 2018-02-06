package melwin.leetcode.medium;

// LEETCODE - 397 - Integer Replacement
//	Bit Operation - 

public class IntegerReplacement {

	public int integerReplacement(int n) {
		
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
				// decrementing doesn't always gives the best solution
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
		
	}

	public static void main(String[] args) {
	}

}

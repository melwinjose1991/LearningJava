package melwin.hackerrank.contests.Twenty17.UniversityCodeSprint_Feb;

import java.math.BigInteger;
import java.util.Scanner;

public class SeperateTheNumbers {

	public static BigInteger nSplit(String input, int n) {
		int start_index = 0, end_index = n;
		int len = input.length();
		BigInteger previous_no = new BigInteger("-1");
		BigInteger first_no = new BigInteger("-1");
		BigInteger one = new BigInteger("1");
		BigInteger minus_one = new BigInteger("-1");

		while (start_index <= len) {
			if (end_index <= len) {
				String no_string = input.substring(start_index, end_index);
				BigInteger no_int = new BigInteger(no_string);
				if (!no_string.equals(no_int.toString())) {
					// #2: trailing zeros condition violated
					return new BigInteger("-1");
				}
				if (previous_no.equals(minus_one)) {
					first_no = no_int;
					previous_no = no_int;
				} else if (previous_no.add(one).equals(no_int)) {
					// continue
					previous_no = no_int;
				} else {
					// #1 : ai - ai-1 != 1 not satisfied
					return new BigInteger("-1");
				}
				start_index += n;
				if (start_index == len)
					break;

				// no_int = 9..9 , next number has n+1 digits
				if (no_string.length() != no_int.add(one).toString().length())
					n++;
				end_index += n;
			} else {
				// last number is short of digits to make
				// a n-digit number
				return new BigInteger("-1");
			}
		}
		return first_no;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		BigInteger minus_one = new BigInteger("-1");
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int len = s.length();
			BigInteger smallest = null;
			for (int i = 1; i <= len / 2; i++) {
				BigInteger tmp = nSplit(s, i);
				//System.out.println(tmp);
				if (!tmp.equals(minus_one)) {
					if (smallest == null || (tmp.compareTo(smallest) == -1))
						smallest = tmp;
				}
			}
			if (smallest == null)
				System.out.println("NO");
			else
				System.out.println("YES " + smallest);
		}
	}
}

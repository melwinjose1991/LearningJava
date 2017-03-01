package melwin.hackerrank.practice.algorithms.strings;

import java.util.Scanner;

public class RichieRich {

	private static int n, k;
	private static boolean[] changed;

	private static String changeString(StringBuilder string, int moves) {
		for (int i = 0; i <= n / 2; i++) {
			if (string.charAt(i) != string.charAt(n - i - 1)) {
				int left = string.charAt(i);
				int right = string.charAt(n - i - 1);
				int max = Math.max(left, right);
				string.setCharAt(i, (char) max);
				string.setCharAt(n - i - 1, (char) max);
				changed[i] = true;
				moves--;
			}
		}
		if (moves < 0)
			return null;

		for (int i = 0; i <= n / 2; i++) {
			if (string.charAt(i) != '9') {
				if(!changed[i]){
					if(moves>=2){
						moves-=2;
						string.setCharAt(i, '9');
						string.setCharAt(n - i - 1, '9');
					}
				}else{
					if(moves>=1){
						moves--;
						string.setCharAt(i, '9');
						string.setCharAt(n - i - 1, '9');
					}
				}
			}
		}
		if (moves >= 1 && n%2!=0) {
			string.setCharAt(n / 2, '9');
		}
		return string.toString();

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		String number = in.next();

		changed = new boolean[n/2 + 1];

		String result = changeString(new StringBuilder(number), k);
		System.out.println(result == null ? "-1" : result);
	}

}

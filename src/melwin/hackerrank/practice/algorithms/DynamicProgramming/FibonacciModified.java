package melwin.hackerrank.practice.algorithms.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		BigInteger[][][] store = new BigInteger[3][3][21];
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				BigInteger t1 = new BigInteger(i+"");
				BigInteger t2 = new BigInteger(j+"");
				BigInteger tk;
				for (int k = 3; k <= 20; k++) {
					tk = (t1.add(t2.multiply(t2)));
					//System.out.print(tk+" ");
					store[i][j][k]=tk;
					t1 = t2;
					t2 = tk;
				}
				//System.out.println();
			}
		}
		
		Scanner in = new Scanner(System.in);

		int t1 = Integer.parseInt(in.next());
		int t2 = Integer.parseInt(in.next());
		int n = Integer.parseInt(in.next());

		System.out.println(store[t1][t2][n]);
	}

}

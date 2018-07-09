package melwin.leetcode.medium;

/* 
 * 813 - Largest Sum of Averages
 * 
 * 		 DP::LCS 1 Array Model (BottomsUp)
 * 			1D for length of A and the other for K.
 * 
 * 			Start by forming groups of 1,2... till you reach K groups.
 * 			dp[i][j] : 	best of A[0]...A[i] elements into j groups.
 * 			dp[i][j] : 	max{ f[p][j-1] + A[p+1]+...+A[i]/(i-p), for p=0,1,...,i-1 }
 * 
 * 					   	dp[i][j] consists of two parts: first j-1 groups' averages and 
 * 						the last group' s average. Considering the last group, its last 
 * 						number must be A[i] and its first number can be from A[0] to A[i]. 
 * 						Suppose the last group starts from A[p+1], we can easily get the 
 * 						average form A[p+1] to A[i] (s in the code below).
 * 						
 */
public class LargestSumofAverages {

	public double largestSumOfAverages(int[] A, int K) {
		if (K == 0 || A.length == 0) {
			return 0;
		}

		int l = A.length;
		double[][] dp = new double[l][K + 1];
		double[] s = new double[l + 1];

		for (int i = 1; i <= l; i++) {
			s[i] = s[i - 1] + A[i - 1];
			dp[i - 1][1] = s[i] / i;
		}

		// Filled column by column. Forming groups of 1,2...K
		for (int j = 2; j <= K; j++) {
			for (int i = 0; i < l; i++) {
				double max = Double.MIN_VALUE;
				for (int p = 0; p < i; p++) {
					double sum = dp[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p);
					max = Double.max(sum, max);
				}
				dp[i][j] = max;
			}
		}
		return dp[l - 1][K];
	}
}

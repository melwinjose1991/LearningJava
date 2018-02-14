package melwin.leetcode;

import java.util.Arrays;

public class Q2 {

	public static int solution(int[] P, int K) {
		int[] days = new int[P.length+2];
		for(int i=0; i<P.length; i++) days[P[i]] = i+1;
		days[P.length] = Integer.MAX_VALUE;
		days[0] = Integer.MAX_VALUE;
		//System.out.println(Arrays.toString(days));
		
		int start = 0, end = K + 1, result = 0, i = 0;
		while (end < days.length) {

			if (days[i] > days[start] || days[i] >= days[end]) {
				if (i == end)
					result = Math.max(result, Math.min(days[start], days[end])-1);
				start = i;
				end = K + 1 + i;
			}

			i++;
		}

		if (result == 0) {
			return -1;
		} else {
			return result;
		}
	}

	
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 5, 4, 2 }, 3));
		System.out.println(solution(new int[] { 3, 1, 5, 4, 2 }, 1));
		System.out.println(solution(new int[] { 3, 1, 5, 4, 2 }, 2));
	}

}

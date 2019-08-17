package melwin.leetcode.medium;

import java.util.Arrays;

// Arrays | XXX

public class CorporateFlightBookings {
	public static int[] corpFlightBookings(int[][] bookings, int n) {
		int[] result = new int[n];
		int[] range = new int[n + 1];
		int sum = 0;
		for (int[] b : bookings) {
			range[b[0] - 1] += b[2];
			range[b[1]] -= b[2];
		}
		for (int i = 0; i < n; i++) {
			sum += range[i];
			result[i] = sum;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		System.out.println(Arrays.toString(corpFlightBookings(bookings, 5)));
	}

}

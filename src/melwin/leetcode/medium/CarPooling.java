package melwin.leetcode.medium;

// Arrays | Range Addition

public class CarPooling {
	public static boolean carPooling(int[][] trips, int capacity) {
		int[] d = new int[1001];
		for (int[] t : trips) {
			d[t[1]] += t[0];
			d[t[2]] -= t[0];
		}
		int cur_pass = 0;
		for (int i = 0; i < d.length; i++) {
			cur_pass += d[i];
			if (cur_pass > capacity) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		System.out.println(carPooling(trips, 4));

		trips = new int[][] { { 2, 1, 5 }, { 3, 3, 7 } };
		System.out.println(carPooling(trips, 5));

		trips = new int[][] { { 2, 1, 5 }, { 3, 5, 7 } };
		System.out.println(carPooling(trips, 3));

		trips = new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
		System.out.println(carPooling(trips, 11));
	}

}

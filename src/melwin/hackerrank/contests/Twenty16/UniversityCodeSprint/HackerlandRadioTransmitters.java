package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = in.nextInt();
		}
		Arrays.sort(x);

		int no_of_transmitters = 0;
		for (int i = 0; i < n;) {
			int first_covered_house_location = x[i];
			int max_transmitter_location = first_covered_house_location + k;
			int transmitter_index = first_covered_house_location;
			while (i < n && x[i] <= max_transmitter_location) {
				transmitter_index = x[i];
				i++;
			}

			int last_covered_house = transmitter_index + k;
			while (i < n && x[i] <= last_covered_house) {
				i++;
			}
			no_of_transmitters++;
		}

		System.out.println(no_of_transmitters);
	}

}

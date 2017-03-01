package melwin.hackerrank.practice.algorithms.implementation;

import java.util.Scanner;

public class RepeatedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();

		int s_size = s.length();
		long full_strings = n / s_size;

		long a_in_s = 0;
		long total_a_count = 0;

		for (int i = 0; i < s_size; i++) {
			if (s.charAt(i) == 'a') {
				a_in_s++;
			}
		}
		
		total_a_count = full_strings * a_in_s;
		
		int left_overs = (int) (n-(s_size*full_strings));
		
		for(int i=0;i<left_overs;i++){
			if(s.charAt(i)=='a'){
				total_a_count++;
			}
		}
		
		System.out.println(total_a_count);
	}

}

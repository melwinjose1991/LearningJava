package melwin.hackerrank.practice.datastructures.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {

	private static int n, q;
	private static HashMap<String, Integer> map;
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		map = new HashMap<>();

		n = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String input = in.nextLine();
			if (map.containsKey(input)) {
				int current_count = map.get(input);
				map.put(input, current_count + 1);
			} else {
				map.put(input, 1);
			}
		}
		q = Integer.parseInt(in.nextLine());
		for (int i = 0; i < q; i++) {
			String input = in.nextLine();
			if(map.containsKey(input)){
				System.out.println(map.get(input));
			}else{
				System.out.println("0");
			}
		}
	}

}

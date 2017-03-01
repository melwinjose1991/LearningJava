package melwin.hackerrank.contests.Twenty16.NCRCodeSprint;

import java.util.Scanner;

public class SpiralMessage {

	private static int m, n;
	private static char matrix[][];
	private static StringBuilder full_string;
	private static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

	private static void loopTheMatrix() {
		int direction = 0;
		int i = m - 1, j = 0, shift = 0;
		while (true) {
			switch (direction) {
			case UP:
				for (i = m - shift - 1; i >= shift; i--) {
					full_string.append(matrix[i][j]);
				}
				i++;
				break;
			case RIGHT:
				for (j = j + 1; j <= n - shift - 1; j++) {
					full_string.append(matrix[i][j]);
				}
				j--;
				break;
			case DOWN:
				for (i = i + 1; i <= m - shift - 1; i++) {
					full_string.append(matrix[i][j]);
				}
				i--;
				break;
			case LEFT:
				for (j = j - 1; j >= shift + 1; j--) {
					full_string.append(matrix[i][j]);
				}
				j++;
				shift++;
				break;
			}
			if(full_string.length()==m*n) break;
			direction = ((direction == LEFT) ? UP : ++direction);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input_line = in.nextLine();
		m = Integer.parseInt((input_line.split(" "))[0]);
		n = Integer.parseInt((input_line.split(" "))[1]);
		matrix = new char[m][n];
		full_string = new StringBuilder(m * n);

		int i = 0;
		while (i<m) {
			input_line = in.nextLine();
			if (input_line.trim().length() == 0)
				break;
			for (int j = 0; j < n; j++) {
				matrix[i][j] = input_line.charAt(j);
			}
			i++;
		}

		loopTheMatrix();

		//System.out.println(full_string);

		StringBuilder trimmed_string = new StringBuilder(m*n);
		for(i=0;i<full_string.length();){
			if(full_string.charAt(i)=='#'){
				trimmed_string.append(" ");
				while(i<full_string.length() && full_string.charAt(i)=='#'){
					i++;
				}
			}else{
				trimmed_string.append(full_string.charAt(i));
				i++;
			}
		}
		
		String final_string = trimmed_string.toString().trim();
		if(final_string.equals("")){
			System.out.println("0");
		}else{
			System.out.println(final_string.split(" ").length);
		}
	}

}

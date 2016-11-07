package melwin.hackerrank.contests.Twenty16.NCRCodeSprint;

import java.util.Scanner;

public class MegaTicTacToe {

	private static int m, n, k;
	private static int game_matrix[][];

	private static boolean checkRight(char ch, int i, int j, int char_required) {
		if (char_required > n - j + 1)
			return false;
		if (char_required == 0)
			return true;
		if (j >= n)
			return false;
		if (game_matrix[i][j] != ch)
			return false;
		return checkRight(ch, i, j + 1, char_required - 1);
	}

	private static boolean checkDown(char ch, int i, int j, int char_required) {
		if (char_required > m - i + 1)
			return false;
		if (char_required == 0)
			return true;
		if (i >= m)
			return false;
		if (game_matrix[i][j] != ch)
			return false;
		return checkDown(ch, i + 1, j, char_required - 1);
	}

	private static boolean checkLowerDiagonal(char ch, int i, int j, int char_required) {
		if (char_required == 0)
			return true;
		if (i >= m || j >= n)
			return false;
		if (game_matrix[i][j] != ch)
			return false;
		return checkLowerDiagonal(ch, i + 1, j + 1, char_required - 1);
	}

	private static boolean checkUpperDiagonal(char ch, int i, int j, int char_required) {
		if (char_required == 0)
			return true;
		if (i >= m || j < 0)
			return false;
		if (game_matrix[i][j] != ch)
			return false;
		return checkUpperDiagonal(ch, i + 1, j - 1, char_required - 1);
	}

	private static boolean didWin(char player) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checkRight(player, i, j, k) || checkDown(player, i, j, k) || 
						checkLowerDiagonal(player, i, j, k)|| checkUpperDiagonal(player, i, j, k))
					return true;
			}
		}
		return false;
	}
	
	private static int optimizedDidWin() {
		int alexis = 0;
		int other = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(game_matrix[i][j]=='O' && alexis == 0){
					if (checkRight('O', i, j, k) || checkDown('O', i, j, k) || 
							checkLowerDiagonal('O', i, j, k)|| checkUpperDiagonal('O', i, j, k))
					alexis = 1;
				}else if(game_matrix[i][j]=='X' && other == 0){
					if (checkRight('X', i, j, k) || checkDown('X', i, j, k) || 
							checkLowerDiagonal('X', i, j, k)|| checkUpperDiagonal('X', i, j, k))
					other = 1;
				}else{
					continue;
				}
				if(alexis == 1 && other == 1){
						return 0;
				}
			}
		}
		if(alexis == 1){
			if(other==1){
				return 0;
			}else{
				return 1;
			}
		}else{
			if(other==1){
				return -1;
			}else{
				return 0;
			}
		}
	}

	private static void readInput() {
		Scanner in = new Scanner(System.in);
		int g = Integer.parseInt(in.nextLine());
		for (int input_number = 0; input_number < g; input_number++) {
			String input = in.nextLine();
			m = Integer.parseInt(input.split(" ")[0]);
			n = Integer.parseInt(input.split(" ")[1]);
			k = Integer.parseInt(input.split(" ")[2]);
			game_matrix = new int[m][n];
			for (int i = 0; i < m; i++) {
				input = in.nextLine();
				for (int j = 0; j < n; j++) {
					game_matrix[i][j] = input.charAt(j);
				}
			}
			switch (optimizedDidWin()) {
			case -1:
				System.out.println("LOSE");
				break;
			case 0:
				System.out.println("NONE");
				break;
			case 1:
				System.out.println("WIN");
				break;
			}
			/*
			boolean alexis = didWin('O');
			boolean other = didWin('X');
			if (alexis) {
				if (other) {
					System.out.println("NONE");
				} else {
					System.out.println("WIN");
				}
			} else {
				if (other) {
					System.out.println("LOSE");
				} else {
					System.out.println("NONE");
				}
			}
			*/
		}

	}

	public static void main(String[] args) {
		readInput();
	}

}

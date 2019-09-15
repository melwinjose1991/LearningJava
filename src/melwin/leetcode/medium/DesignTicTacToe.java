package melwin.leetcode.medium;

// Design | Arrays

public class DesignTicTacToe {
	static class TicTacToe {

		private int[] row_checks, col_checks, diag_checks;
		private int n, moves;

		public TicTacToe(int n) {
			row_checks = new int[n];
			col_checks = new int[n];
			diag_checks = new int[2];
			this.n = n;
			this.moves = 0;

		}

		public int move(int row, int col, int player) {
			if (moves == n * n)
				return 0;
			else {
				int increment = player == 1 ? 1 : -1;
				row_checks[row] += increment;
				col_checks[col] += increment;
				if (row == col) {
					diag_checks[0] += increment;
				}
				if (n - 1 - row == col) {
					diag_checks[1] += increment;
				}
				for (int i = 0; i < n; i++) {
					if (row_checks[i] == n)
						return 1;
					if (row_checks[i] == -n)
						return 2;

					if (col_checks[i] == n)
						return 1;
					if (col_checks[i] == -n)
						return 2;
				}
				if (diag_checks[0] == n)
					return 1;
				if (diag_checks[0] == -n)
					return 2;
				if (diag_checks[1] == n)
					return 1;
				if (diag_checks[1] == -n)
					return 2;
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe(3);
		System.out.println(game.move(0, 0, 1));
		System.out.println(game.move(0, 2, 2));
		System.out.println(game.move(2, 2, 1));
		System.out.println(game.move(1, 1, 2));
		System.out.println(game.move(2, 0, 1));
		System.out.println(game.move(1, 0, 2));
		System.out.println(game.move(2, 1, 1));
	}

}

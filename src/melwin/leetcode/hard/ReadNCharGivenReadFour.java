package melwin.leetcode.hard;

// 157 - Read N Characters Given Read4 - Corner Cases

public class ReadNCharGivenReadFour {

	public int read(char[] buf, int n) {
		boolean eof = false;
		int charsRead = 0;
		char[] buf4 = new char[4];

		while (!eof && charsRead < n) {
			int size = read4(buf4);
			if (size < 4) {
				eof = true;
			}

			if (charsRead + size > n) {
				size = n - charsRead;
			}

			System.arraycopy(buf4, 0, buf, charsRead, size);
			charsRead += size;
		}

		return charsRead;
	}

	public int read4(char[] buf) {
		return 0;
	}

	public static void main(String[] args) {
	}

}

package melwin.leetcode.hard;

//157 - Read N Characters Given Read4 - Corner Cases

public class ReadNCharGivenReadFourII {

	private char[] buffer = new char[4];
	int offset = 0, buff_size = 0;

	public int read(char[] buf, int n) {
		int bytes_read = 0;
		boolean eof = false;
		while (!eof && bytes_read < n) {
			int sz = (buff_size > 0) ? buff_size : read4(buffer);
			if (buff_size == 0 && sz < 4)
				eof = true;
			int bytes_to_write = Math.min(n - bytes_read, sz);
			System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, bytes_read /* destPos */,
					bytes_to_write /* length */);
			offset = (offset + bytes_to_write) % 4;
			buff_size = sz - bytes_to_write;
			bytes_read += bytes_to_write;
		}
		return bytes_read;
	}

	public int read4(char[] buf) {
		return 0;
	}

	public static void main(String[] args) {
	}

}

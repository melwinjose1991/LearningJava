package melwin.learning.System.MultiThreading;

public class Fibonacci {

	public static class PFibo extends Thread {
		private int x;
		public long answer;

		public PFibo(int x) {
			this.x = x;
		}

		public void run() {
			if (x <= 2)
				answer = 1;
			else {
				try {
					PFibo t = new PFibo(x - 1);
					t.start();

					long y = RFibo(x - 2);

					t.join();
					answer = t.answer + y;

				} catch (InterruptedException ex) {
				}
			}
		}
	}

	public static long RFibo(int no) {
		if (no == 1 || no == 2) {
			return 1;
		}
		return RFibo(no - 1) + RFibo(no - 2);
	}

	public static void main(String[] args) throws Exception {
		try {
			int n = 10;
			long start = System.currentTimeMillis();
			PFibo f = new PFibo(n);
			f.start();
			f.join();
			long end = System.currentTimeMillis();
			System.out.println("Parallel-Fibonacci:" + f.answer + "\tTime:" + (end - start));

			start = System.currentTimeMillis();
			long result = RFibo(n);
			end = System.currentTimeMillis();
			System.out.println("Normal-Fibonacci:" + result + "\tTime:" + (end - start));

		} catch (Exception e) {
		}
	}
}

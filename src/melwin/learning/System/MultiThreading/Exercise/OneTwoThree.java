package melwin.learning.System.MultiThreading.Exercise;

public class OneTwoThree {

	private static int loops = 3;
	private static Object lock = new Object();
	private static int thread_turn = 1;

	public static class Printer implements Runnable {
		private int my_number;

		public Printer(int no) {
			my_number = no;
		}

		@Override
		public void run() {
			for (int i = 0; i < loops; i++) {
				synchronized (lock) {
					while (thread_turn != my_number) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(my_number);
					thread_turn = thread_turn == 3 ? 1 : thread_turn + 1;
					lock.notifyAll();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= loops; i++) {
			new Thread(new Printer(i)).start();
		}

		Thread.sleep(1000);
	}

}

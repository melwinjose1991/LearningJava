package melwin.learning.System.MultiThreading.Exercise;

// ||ONE TWO THREE|| ||EXCERCIS||
public class OneTwoThree {

	private static int number_of_threads = 3;
	private static Object lock = new Object();
	private static int thread_turn = 1;

	public static class Printer implements Runnable {
		private int my_number;

		public Printer(int no) {
			my_number = no;
		}

		@Override
		public void run() {
			for (int i = 0; i < number_of_threads; i++) {
				synchronized (lock) {
					while (thread_turn != my_number) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(my_number);
					thread_turn = thread_turn == number_of_threads ? 1 : thread_turn + 1;
					lock.notifyAll();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= number_of_threads; i++) {
			new Thread(new Printer(i)).start();
		}

		Thread.sleep(1000);
	}

}

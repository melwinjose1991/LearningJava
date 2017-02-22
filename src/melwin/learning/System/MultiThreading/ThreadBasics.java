package melwin.learning.System.MultiThreading;

// THREAD RUNNABLE

public class ThreadBasics {

	private static int counter;

	private synchronized static void incrementCounter() {
		counter++;
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				incrementCounter();
			}
		}
	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				incrementCounter();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread runner = new Thread(new MyRunnable());
		MyThread threader = new MyThread();

		runner.start();
		threader.start();

		runner.join();
		threader.join();

		System.out.println(counter);
	}

}

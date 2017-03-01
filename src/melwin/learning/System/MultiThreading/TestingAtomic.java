package melwin.learning.System.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

// ||ATOMIC INTEGER|| 
// ||ATOMIC INTEGER vs VOLATILE|| : change to volatile version of `done` and 
// 		observe the behavior. volatile on guarantees visibility

public class TestingAtomic {

	private static AtomicInteger done = new AtomicInteger(0);
	// private static volatile int done = 0;
	private static int no_of_threads = 10;

	static class MyRunnable implements Runnable {

		public void run() {
			try {
				Thread.sleep(2000);
				done.incrementAndGet();
				// done++;
				System.out.println(Thread.currentThread().getId() + ":: Done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < no_of_threads; i++) {
			Thread t = new Thread(new MyRunnable());
			t.start();
		}

		while (done.get() != no_of_threads) {
			// while (done != no_of_threads) {
			System.out.println("Main-Thread waiting for worker threads to finish");
			Thread.sleep(500);
		}

		System.out.println("main-thread all threads are done");
	}
}

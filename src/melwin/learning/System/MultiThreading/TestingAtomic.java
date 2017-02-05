package melwin.learning.System.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

// ||ATOMIC INTEGER||

public class TestingAtomic {

	private static AtomicInteger done = new AtomicInteger(0);
	private static int no_of_threads = 10;

	static class MyRunnable implements Runnable {

		public void run() {
			try {
				Thread.sleep(2000);
				done.incrementAndGet();
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
		
		while(done.get()!=no_of_threads){
			System.out.println("Main-Thread going to sleep");
			Thread.sleep(500);
		}
		
		System.out.println("main-thread all threads are done");
	}
}

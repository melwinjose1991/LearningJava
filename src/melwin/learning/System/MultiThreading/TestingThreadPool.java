package melwin.learning.System.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + id + " starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
		System.out.println(Thread.currentThread().getName() + " : " + id + " done");
	}
}

public class TestingThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		System.out.println("All tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException ignored) {
		}
		System.out.println("All tasks done");
	}
}
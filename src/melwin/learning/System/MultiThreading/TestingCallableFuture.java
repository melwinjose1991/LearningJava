package melwin.learning.System.MultiThreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class TestingCallableFuture {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws TimeoutException {
				Random random = new Random();
				int duration = random.nextInt(4000);
				if (duration > 2000) {
					throw new TimeoutException("Sleeping for too long.");
				}

				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException ignored) {
				}
				System.out.println("Finished.");
				return duration;
			}
		});

		executor.shutdown();
		try {
			System.out.println("Result is: " + future.get());

		} catch (InterruptedException ignored) {
		} catch (ExecutionException e) {
			TimeoutException ex = (TimeoutException) e.getCause();
			System.out.println(ex.getMessage());
		}
	}
}

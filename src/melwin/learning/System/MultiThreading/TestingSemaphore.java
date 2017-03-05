package melwin.learning.System.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// ||SEMAPHORE||

public class TestingSemaphore {
	public static class Connection {

		private static Connection instance = new Connection();
		private Semaphore sem = new Semaphore(2, true);
		private int connections = 0;

		private Connection() {
		}

		public static Connection getInstance() {
			return instance;
		}

		public void connect() {
			System.out.println(sem);
			try {
				sem.acquire();
				doConnect();
			} catch (InterruptedException ignored) {
			} finally {
				sem.release();
				// sem.release(); this would screw up
				// the permit limit
			}
		}

		public void doConnect() {
			synchronized (this) {
				connections++;
				System.out.println(Thread.currentThread().getName() + " : connections:" + connections);
			}
			try {
				System.out.println(Thread.currentThread().getName() + " working");
				Thread.sleep(2000);
			} catch (InterruptedException ignored) {
			}
			synchronized (this) {
				connections--;
				System.out.println(Thread.currentThread().getName() + " DONE, connections: " + connections);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 6; i++) {
			executor.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}

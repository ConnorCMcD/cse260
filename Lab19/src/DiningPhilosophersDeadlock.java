import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class DiningPhilosophersDeadlock {
	static ReentrantLock[] forkLock = {
			new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock(),
			new ReentrantLock()
	};
	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new PhilosopherTask(0));
		executor.execute(new PhilosopherTask(1));
		executor.execute(new PhilosopherTask(2));
		executor.execute(new PhilosopherTask(3));
		executor.execute(new PhilosopherTask(4));
		executor.shutdown();
	}
	
	public static class PhilosopherTask implements Runnable {
		int philosopher, leftFork, rightFork;
		PhilosopherTask(int n) {
			philosopher = n;
			leftFork = n;
			if (philosopher > 0) {
				rightFork = philosopher - 1;
			} else {
				rightFork = 4;
			}
		}
		public void run() {
			try {
				while (true) {
					// take the left fork
					forkLock[leftFork].lock();
					System.out.println("The philosopher " + philosopher
							+ " took his left fork " + leftFork);
					Thread.sleep(1000);
					// take the right fork
					System.out.println("The philosopher " + philosopher
							+ " tries to take his right fork " + rightFork);
					forkLock[rightFork].lock();
					System.out.println("The philosopher " + philosopher
							+ " took his right fork " + rightFork);
					System.out.println("The philosopher " + philosopher + " eats.");
					System.out.println("The philosopher " + philosopher
							+ " releases his right fork " + rightFork);
					forkLock[rightFork].unlock();
					System.out.println("The philosopher " + philosopher
							+ " releases his left fork " + leftFork);
					forkLock[leftFork].unlock();
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

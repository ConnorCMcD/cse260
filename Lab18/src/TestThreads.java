
public class TestThreads {

	public static void main(String[] args) {
		for(int i=0; i<20; i++) {
			NonSynchronizedThreads.main(args);
		}
		System.out.println("Waiting to start Synchronized Threads");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			//Squelch
		}
		for(int i=0; i<20; i++) {
			SynchronizedThreads.main(args);
		}
	}

}

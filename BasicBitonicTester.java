import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;


class BasicBitonicTester implements Runnable {
	final int numThr;

	int width;
	Bitonic bitonic;
	AtomicInteger[] counterArray;
	CyclicBarrier basicTestBarr;


	BasicBitonicTester(int myNumThr) {
		this.numThr = myNumThr;
		this.width = 32; // Change this to change the network's width
		this.bitonic = new Bitonic(width);
		this.counterArray = new AtomicInteger[width];
		for (int i=0;i<width;i++) {
			counterArray[i] = new AtomicInteger(0);
		}

		Runnable basicTestRunnable = new Runnable() {
			public void run() {
				printResults("Basic Test");
			}
		};

		this.basicTestBarr = new CyclicBarrier(numThr, basicTestRunnable);
	}

	/*
	 * If you want to print out the results of a test, use this method. You
	 * can use barriers to ensure all threads finish before calling this function.
	 * Feel free to add additional functionality to see what goes on.
	 */

	void printResults(String testName) {
		System.out.println("------------- " + testName + " --------------");
		int colNum = 5;
		for (int i=0; i<width; i+= colNum) {
			for (int j=0; j<colNum && (i+j < width); j++) {
				System.out.print("[" + (i + j) + "]=" + counterArray[i+j] + "; ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}

	public void run() {

		try {

	        testCounting();
	        basicTestBarr.await();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void testCounting() {
		// Choose random input wires
		ThreadLocal<Integer> outwire = new ThreadLocal<Integer>();
		outwire.set(bitonic.traverse((int) Math.random() % width));
		counterArray[outwire.get()].getAndIncrement();
	}
}

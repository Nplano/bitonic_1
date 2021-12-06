import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This tester class should contain your tests. The TAs will replace this with our
 * own tester class, but be sure to write tests here to check the correctness of
 * your program.
**/
class BitonicTester implements Runnable {
	final int numThr;

	int width;
	Bitonic bitonic;
	AtomicInteger[] counterArray;
    CyclicBarrier basicTestBarr;
    private final ReentrantLock lock = new ReentrantLock();

	BitonicTester(int myNumThr) {
		this.numThr = myNumThr;
		this.width = 8;
		this.bitonic = new Bitonic(width);
        this.counterArray = new AtomicInteger[width];
        for (int i=0;i<width;i++) {
            counterArray[i] = new AtomicInteger(0);
        }

        Runnable basicTestRunnable = new Runnable() {
            public void run() {
                printResults("My test");
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
        //Begin writing your tests here
        try {
            testCounting();
            basicTestBarr.await();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


	}

    // my test loops through 10 loops and each thread goes through and adds
    // to the counter. Then I loop through 9 loops and decrement the counter using
    // and anti token the result a counter number = to the number of threads
    private void testCounting() {
        // Choose random input wires

        for( int i =0 ; i <10 ; i ++){
            ThreadLocal<Integer> outwire = new ThreadLocal<Integer>();
            double temp =  Math.random()*width ;
            int random = (int) temp  ;
            outwire.set(bitonic.traverse(random));
            counterArray[outwire.get()].getAndIncrement();

        }
        for( int i =0 ; i <9 ; i ++){
            ThreadLocal<Integer> outwire = new ThreadLocal<Integer>();
            double temp =  Math.random()*width ;
            int random = (int) temp  ;
            outwire.set(bitonic.antiTraverse(random));
            counterArray[outwire.get()].getAndDecrement();

        }

    }



}

/**
 *  This is an entry point to the program. The main method sets the threads off
 *  so that they can invoke the methods in the tester class.
**/
public class TestBitonic {
	public static void main(String[] args) throws InterruptedException {
		int numThr = 1;
		if (args.length > 0)
			numThr = Integer.parseInt(args[0]);

        /**
         *  Instantiate an array of threads and the BitonicTester class.
         *  Initialize each thread, and call its start() method.
         *  Be sure to wait until all threads have joined before exiting.
        **/
        Thread threads[] = new Thread[numThr];
        BitonicTester tester = new BitonicTester(numThr);

        for (int i = 0; i < numThr; i++) {
            threads[i] = new Thread(tester);
        }

        for (int i = 0; i < numThr; i++) {
            threads[i].start(); //Run the threads
        }
        for (int i = 0; i < numThr; i++) {
            threads[i].join(); //Run the threads
        }

        System.out.println("Program finished running");

	}
}

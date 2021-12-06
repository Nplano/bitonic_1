/**
 *  A basic class to run your program. We do not recommend changing anything in
 *  this file.
**/
public class BasicTestBitonic {
	public static void main(String[] args) throws InterruptedException {
		int numThr = 1;
		if (args.length > 0)
			numThr = Integer.parseInt(args[0]);

		Thread threads[] = new Thread[numThr];
		BasicBitonicTester tester = new BasicBitonicTester(numThr);

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

/* A constants class that you may choose to use in their
   Bitonic/Merger/Balancer implementation. 
   It's completely optional and more for readability

   For a Balancer: 
	 - TOP/BOT wire
   For a Merger Network: 
	 - TOP/BOT half-width Merger subnetwork
   For a Bitonic Network: 
	 - TOP/BOT half-width Bitonic subnetwork
   Then again, if that's confusing, this class can be safely ignored */
public final class Consts {
	// If you want to use these constants do:
	// 	- Consts.TOP
	//	- Consts.BOT
	// 
	// If you have everything in a package, you might need
	// to do a 'import static package.Consts.*' in the files
	// that you use these in.
	public static final int TOP = 0;
	public static final int BOT = 1;

	// You don't construct an instance of this class
	private Consts() {
		throw new AssertionError();
	}
}

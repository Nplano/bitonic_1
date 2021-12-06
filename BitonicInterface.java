public interface BitonicInterface {
	/*
	 * Have a token taverse the Bitonic network
	 *
	 * @param input  the number of the input wire we will 
	 * use to enter the network 
	 * @return the number of the output wire we exit at
	 */
	public int traverse(int input);

	/*
	 * Have an antitoken taverse the Bitonic network
	 *
	 * @param input  the number of the input wire we will 
	 * use to enter the network 
	 * @return the number of the output wire we exit at
	 */
	public int antiTraverse(int input);

}

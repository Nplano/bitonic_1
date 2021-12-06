public interface BalancerInterface {
	 /*
	 * Traverse this Balancer (should be synchronized)
	 *
	 * @return 0/TOP to indicate we used the upper wire to exit;
	 *	1/BOT to indicate we used the lower wire to exit 
	 */
	public int traverse();
	 
	/*
	 * Have an antitoken traverse this Balancer (should be synchronized)
	 *
	 * @return 0/TOP to indicate we used the upper wire to exit;
	 *	1/BOT to indicate we used the lower wire to exit 
	 */
	public int antiTraverse();
}

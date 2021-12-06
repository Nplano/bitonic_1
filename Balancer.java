public class Balancer implements BalancerInterface {

    /** Add the necessary fields and implement all the methods in this file to
      * implement the Balancer class. Be sure to look at the definition for the
      * interface that this class implements.
      **/
    Boolean toggle =true;
	public synchronized int traverse() {
        
        try{
            if(toggle){
                return 0;
            }
            else{
                return 1;
            }

        }finally {
            toggle =!toggle;
        }
	}

	public synchronized int antiTraverse() {
        try{
            if(toggle){
                return 1;
            }
            else{
                return 0;
            }

        }finally {
            toggle =!toggle;
        }
	}
}

public class Bitonic implements BitonicInterface {

    /**
     *  Add the necessary fields and implement the methods in this file to
     *  implement the Bitonic class. Be sure to look at the definition for the
     *  interface that this class implements.
     **/
    Bitonic[] half;
    Merger merger;
    final int width;

	public Bitonic(int myWidth) {
        width = myWidth;
        merger= new Merger(width);
        if ( width >2){
            half = new Bitonic[]{new Bitonic(width/2), new Bitonic(width/2)};
        }
	}

	public int traverse(int input) {
        int output =0;
        if(width > 2){
            //
            output = half[input/(width/2)].traverse(input/2);

        }

        return merger.traverse((input >= (width / 2) ? (width / 2) : 0) + output);


	}

	public int antiTraverse(int input) {
        int output =0;
        if(width > 2){
            //
            output = half[input/(width/2)].antiTraverse(input/2);

        }

        return merger.antiTraverse((input >= (width / 2) ? (width / 2) : 0) + output);
	}
}

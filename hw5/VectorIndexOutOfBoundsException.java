/**
* The Exception to be thrown when trying to access
* a out of bounds index in a Vector.
* @author Yuanhan Pan
* @version 1.0
**/
public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
    * Default initialization of this exception.
    **/
    public VectorIndexOutOfBoundsException() {
        super();
    }

    /**
    * Initializes this exception with a message.
    * @param  message  a String representing a custom
    *                  message to be initialized
    **/
    public VectorIndexOutOfBoundsException(String message) {
        super(message);
    }
}
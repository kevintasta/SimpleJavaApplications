/**
* The Exception to be thrown when trying to access
* a out of bounds index in a Matrix.
* @author Yuanhan Pan
* @version 1.0
**/
public class MatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
    * Default initialization of this exception.
    **/
    public MatrixIndexOutOfBoundsException() {
        super();
    }

    /**
    * Initializes this exception with a message.
    * @param  message  a String representing a custom
    *                  message to be initialized
    **/
    public MatrixIndexOutOfBoundsException(String message) {
        super(message);
    }
}
/**
* The Exception to be thrown when trying to perform
* an illegal Linear Algebra operation.
* @author Yuanhan Pan
* @version 1.0
**/
public class IllegalOperandException extends Exception {

    /**
    * Default initialization of this exception.
    **/
    public IllegalOperandException() {
        super();
    }

    /**
    * Initializes this exception with a message.
    * @param  message  a String representing a custom
    *                  message to be initialized
    **/
    public IllegalOperandException(String message) {
        super(message);
    }
}
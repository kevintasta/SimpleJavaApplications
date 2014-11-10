/**
 * Immutable abstraction for Vector
 *
 * @author Michael Maurer
 * @author Yuanhan Pan
 * @version 1.3
 */
public class Vector {

    /*
    Create final instance variables
    */
    private final double[] vector;
    private int length;

    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(double[] vector) {
        this.vector = vector;
        length = vector.length;
    }

    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return double located at index 'i' in vector
     */
    public double get(int i) {
        if (i >= length) {
            String message = "Index " + i + " not found in"
                + " vector of length " + length + ".";
            throw new VectorIndexOutOfBoundsException(message);
        }
        return vector[i];
    }

    /**
     * Get's the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }

    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String a = "";
        for (int i = 0; i < length; i++) {
            a = a + vector[i] + "\t";
        }
        return a;
    }
}
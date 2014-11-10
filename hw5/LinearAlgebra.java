/**
* Class for performing linear algebra operations
* @author Yuanhan Pan
* @version 1.0
**/
public class LinearAlgebra {

    /**
    * Multiplys a matrix and a vector if their dimensions
    * are compatible.
    * @param  m  the Matrix for the multiplication
    * @param  v  the Vector for the multiplication
    * @return    a Vector product of m and v
    **/
    public static Vector matrixVectorMultiply(Matrix m, Vector v)
        throws IllegalOperandException {
        if (m.getWidth() != v.getLength()) {
            String message = "Sorry, something went wrong.\n"
                + "Cannot multiply a matrix of width " + m.getWidth()
                + " with a vector of length " + v.getLength() + ".";
            throw new IllegalOperandException(message);
        }
        double[] product = new double[v.getLength()];
        for (int row = 0; row < m.getHeight(); row++) {
            double rowSum = 0;
            for (int col =  0; col < m.getWidth(); col++) {
                rowSum = rowSum + m.get(row, col) * v.get(col);
            }
            product[row] = rowSum;
        }
        return new Vector(product);
    }

    /**
    * Adds two matrices if they are the same dimensons.
    * @param  m1  the first Matrix for the addition
    * @param  m2  the second Matrix for the addition
    * @return     a Matrix sum of m1 and m2
    **/
    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {
        if ((m1.getWidth() != m2.getWidth())
            || (m1.getHeight() != m2.getHeight())) {
            String message = "Sorry, something went wrong.\n"
                + "Cannot add a " + m1.getHeight() + "x"
                + m1.getWidth() + " matrix to a " + m2.getHeight()
                + "x" + m2.getWidth() + " matrix.";
            throw new IllegalOperandException(message);
        }
        double[][] sum = new double[m1.getHeight()][m1.getWidth()];
        for (int row = 0; row < m1.getHeight(); row++) {
            for (int col =  0; col < m1.getWidth(); col++) {
                sum[row][col] = m1.get(row, col) + m2.get(row, col);
            }
        }
        return new Matrix(sum);
    }

    /**
    * Takes the dot product of two Vectors if their
    * lengths are compatible.
    * @param  v1  the first Vector for the dot product
    * @param  v2  the second Vector for the dot product
    * @return     a double representing the dot product
    *             of v1 and v2
    **/
    public static double dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            String message = "Sorry, something went wrong.\n"
                + "Cannot take the dot product of a vetor of length "
                + v1.getLength() + " with a vector of length "
                + v2.getLength() + ".";
            throw new IllegalOperandException(message);
        }
        double dotproduct = 0;
        for (int i = 0; i < v1.getLength(); i++) {
            dotproduct = dotproduct + v1.get(i) * v2.get(i);
        }
        return dotproduct;
    }

    /**
    * Takes the sum of two Vectors if they have the same
    * lengths.
    * @param  v1  the first Vector for the addition
    * @param  v2  the second Vector for the addition
    * @return     a Vector sum of v1 and v2
    **/
    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            String message = "Sorry, something went wrong.\n"
                + "Cannot add a vetor of length " + v1.getLength()
                + " with a vector of length " + v2.getLength() + ".";
            throw new IllegalOperandException(message);
        }
        double[] sum = new double[v1.getLength()];
        for (int i = 0; i < v1.getLength(); i++) {
            sum[i] = v1.get(i) + v2.get(i);
        }
        return new Vector(sum);
    }
}
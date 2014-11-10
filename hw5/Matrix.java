/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer
 * @author Yuanhan Pan
 * @version 1.3
 */
public class Matrix {

    /*
    Create final instance variables
    */
    private final double[][] matrix;
    private final int height;
    private final int width;

    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
    }

    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j) throws MatrixIndexOutOfBoundsException {
        if (i >= height || j >= width) {
            String message = "Index " + i + "," + j + " not found in"
                + height + " by " + width + " matrix.";
            throw new MatrixIndexOutOfBoundsException(message);
        }
        return matrix[i][j];
    }

    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String a = "";
        for (int row = 0; row < height; row++) {
            for (int col =  0; col < width; col++) {
                a = a + matrix[row][col] + "\t";
            }
            a = a + "\n";
        }
        return a;
    }
}
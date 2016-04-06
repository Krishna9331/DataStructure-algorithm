package chapter2.backtracking;

/**
 * Created by mishrk3 on 4/5/2016.
 */

/**
 * The below class finds the maximum number of connected 1.
 * <p>
 * The code follow the logic is for each index traverse in all 8 direction recursively and keep track of maximum
 * region found
 */
public class MatrixConnectedCell {

    /**
     * @param matrix the matrix
     * @param i      row num of cell
     * @param j      col num of cell
     * @param l      max possible row num
     * @param h      max possible col num
     * @return value of the requested cell if valid otherwise 0.
     * <p>
     * Below method checks if the given cell is valid or not and then returns the value
     */
    private static int maxSize = 0;

    private int getVal(int[][] matrix, int i, int j, int l, int h) {
        if (i < 0 || i >= l || j < 0 || j >= h) {
            return 0;
        }
        return matrix[i][j];
    }

    /**
     * @param matrix    the matrix
     * @param r         row num of cell
     * @param c         col num of cell
     * @param l         max possible row num
     * @param h         max possible col num
     * @param size      current size starting from 0
     * @param container the matrix of visited cells marked as true
     */
    void findMaxBlock(int[][] matrix, int r, int c, int l, int h, int size, boolean container[][]) {
        if (r >= l || c >= h) {
            return;
        }
        //mark the cell as visited
        container[r][c] = true;
        size++;
        if (size > maxSize) {
            maxSize = size;
        }
        //all possible 8 directions for a cell
        int direction[][] = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        for (int i = 0; i < 8; i++) {
            int newI = r + direction[i][0];
            int newJ = c + direction[i][1];
            int val = getVal(matrix, newI, newJ, l, h);
            if (val > 0 && (container[newI][newJ] == false)) {
                findMaxBlock(matrix, newI, newJ, l, h, size, container);
            }
        }
        //at end of one cell traversal mark all cell with 1 as false so that it can be visited again by another cell
        //traversal
        container[r][c] = false;
    }

    int getMaxOnes(int[][] matrix, int rMax, int colMax) {
        int size = 0;
        boolean[][] container = new boolean[rMax][colMax];
        for (int i = 0; i < rMax; i++) {
            for (int j = 0; j < colMax; j++) {
                //start the traversal only if cell value is 1
                if (matrix[i][j] == 1) {
                    findMaxBlock(matrix, i, j, rMax, colMax, size, container);

                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        MatrixConnectedCell mxcl = new MatrixConnectedCell();
        int[][] matrix = {{1, 1, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {1, 0, 0, 0, 1}, {0, 1, 0, 0, 1}};
        int maxSize = mxcl.getMaxOnes(matrix, 5, 5);
        System.out.println("Result is: " + maxSize);
    }
}

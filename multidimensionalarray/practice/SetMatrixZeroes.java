package multidimensionalarray.practice;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean colFirst = false;

        for (int i=0;i<n;i++) {

            // as first cell for first row and first column are same
            // use an additional variable for the first column
            if (matrix[i][0] == 0) {
                colFirst = true;
            }

            for (int j=1;j<m;j++) {
                // if any cell has 0 then set the first cell of the
                // corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // now set the cells of every row and column to 0 which has first cell
        // of that row or column marked as 0
        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if the first row is marked as 0 then set all the cells in the first row to 0
        if (matrix[0][0] == 0) {
            for (int i=0;i<m;i++) {
                matrix[0][i] = 0;
            }
        }

        // if the first column is marked as 0 then set all the cells in the first column to 0
        if (colFirst) {
            for (int i=0;i<n;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

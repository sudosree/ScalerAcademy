package multidimensionalarray.practice;

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // first check if the matrix can be reshaped
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[r][c];
        int rows = 0, cols = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                res[rows][cols] = mat[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
}

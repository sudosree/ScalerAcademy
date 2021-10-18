package multidimensionalarray.practice;

public class PrintDiagonal {

    private static void printDiagonal(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int k=0; k<m; k++) {
            int i=k, j=0;
            while (i >= 0 && j < n) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
        for (int k=1; k<n; k++) {
            int i=m-1, j=k;
            while (j < n) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20},
        };
        printDiagonal(mat);
    }
}

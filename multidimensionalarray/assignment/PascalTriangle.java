package multidimensionalarray.assignment;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *      [1],
 *      [1,1],
 *      [1,2,1],
 *      [1,3,3,1],
 *      [1,4,6,4,1]
 * ]
 */
public class PascalTriangle
{
    private static int[][] solve(int A) {
        int[][] matrix = new int[A][];
        for (int i=0;i<A;i++) {
            matrix[i] = new int[i+1];
            for (int j=0;j<=i;j++) {
                // first and last element will always be 1
                if (j == 0 || j == i) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args)
    {
        int A = 5;
        int[][] res = solve(A);
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<res[0].length;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}

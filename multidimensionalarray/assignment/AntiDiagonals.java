package multidimensionalarray.assignment;

/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 *
 * Example:
 *
 * Input:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Return the following :
 *
 * [
 *   [1],
 *   [2, 4],
 *   [3, 5, 7],
 *   [6, 8],
 *   [9]
 * ]
 *
 * Input :
 * 1 2
 * 3 4
 *
 * Return the following  :
 *
 * [
 *   [1],
 *   [2, 3],
 *   [4]
 * ]
 */
public class AntiDiagonals
{
    private static int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] res = new int[2*n-1][];
        int p = 0;
        // start with column
        for (int j=0; j<n; j++) {
            res[p] = new int[j+1];
            for (int i=0,k=j; i<n && k>=0; i++,k--) {
//                System.out.print(A[i][k] + " ");
                res[p][i] = A[i][k];
            }
            p++;
        }

        // start with row
        for (int i=1; i<n; i++) {
            res[p] = new int[n-i];
            int l=0;
            for (int k=i,j=n-1; k<n && j>=1; k++,j--) {
//                System.out.print(A[k][j] + " ");
                res[p][l] = A[k][j];
                l++;
            }
            p++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] res = diagonal(A);
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<res[0].length;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package multidimensionalarray.practice;

import java.util.*;

/**
 * Problem Description
 *
 * Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 103.
 *
 * 1 <= B <= N
 *
 * -102 <= A[i][j] <= 102.
 *
 *
 *
 * Input Format
 *
 * First arguement is an 2D integer matrix A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return a single integer denoting the maximum sum of submatrix of size B x B.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [
 *         [1, 1, 1, 1, 1]
 *         [2, 2, 2, 2, 2]
 *         [3, 8, 6, 7, 3]
 *         [4, 4, 4, 4, 4]
 *         [5, 5, 5, 5, 5]
 *      ]
 *  B = 3
 *
 * Input 2:
 *
 *  A = [
 *         [2, 2]
 *         [2, 2]
 *     ]
 *  B = 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  48
 *
 * Output 2:
 *
 *  8
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *     Maximum sum 3 x 3 matrix is
 *     8 6 7
 *     4 4 4
 *     5 5 5
 *     Sum = 48
 *
 * Explanation 2:
 *
 *  Maximum sum 2 x 2 matrix is
 *   2 2
 *   2 2
 *   Sum = 8
 */
public class MaxSumSquareSubMatrix
{

    /**
     * TC = O(n^2k^2)
     */
    private static void solve(int[][] A, int k) {
        int max_sum = Integer.MIN_VALUE;
        int r = -1, c = -1;
        int n = A.length;
        for (int p=0;p<n-k+1;p++) {
            for (int q=0;q<n-k+1;q++) {
                int sum = 0;
                for (int i=p;i<p+k;i++) {
                    for (int j=q;j<q+k;j++) {
                        sum += A[i][j];
                    }
                }
                if (sum > max_sum) {
                    r = p;
                    c = q;
                }
            }
        }
        if (r != -1 && c != -1) {
            for (int i=r;i<r+k;i++) {
                for (int j=c;j<c+k;j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * TC = O(n^2)
     */
    public static int solve1(int[][] A, int B) {
        int n = A.length;
        int[][] wind_sum = new int[n][n];

        // first calculate the window sum array where each cell (i,j) will store the sum of
        // elements from jth column to (j+B-1)th column
        for (int i=0;i<n;i++) {
            // calculate for the first window in each row
            int sum = 0;
            for (int j=0;j<B;j++) {
                sum += A[i][j];
            }
            wind_sum[i][0] = sum;
            // calculate for the rest of the window in each row
            for (int j=1;j<n-B+1;j++) {
                sum = sum - A[i][j-1] + A[i][j+B-1];
                wind_sum[i][j] = sum;
            }
        }

        // calculate the sum of all B X B matrix
        int max = Integer.MIN_VALUE;
        for (int j=0;j<n-B+1;j++) {
            // calculate the sum of first submatrix in this column
            int sum = 0;
            for (int i=0;i<B;i++) {
                sum += wind_sum[i][j];
            }
            max = Math.max(max, sum);
            // calculate the sum of remaining submatrices in this column
            for (int i=1;i<n-B+1;i++) {
                sum = sum - wind_sum[i-1][j] + wind_sum[i+B-1][j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        /*int[][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };*/
        int[][] A = {
                {2,2},
                {2,2}
        };
        System.out.println(solve1(A,2));
        Map<Integer, Integer> map = new HashMap<>();
        map.remove("abc");
    }
}

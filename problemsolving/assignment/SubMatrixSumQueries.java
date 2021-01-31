package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 *     Rows are numbered from top to bottom and columns are numbered from left to right.
 *     Sum may be large so return the answer mod 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 *
 *
 * Output Format
 *
 * Return an integer array containing the submatrix sum for each query.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [   [1, 2, 3]
 *          [4, 5, 6]
 *          [7, 8, 9]   ]
 *  B = [1, 2]
 *  C = [1, 2]
 *  D = [2, 3]
 *  E = [2, 3]
 *
 * Input 2:
 *
 *  A = [   [5, 17, 100, 11]
 *          [0, 0,  2,   8]    ]
 *  B = [1, 1]
 *  C = [1, 4]
 *  D = [2, 2]
 *  E = [2, 4]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [12, 28]
 *
 * Output 2:
 *
 *  [22, 19]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 *  For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 *
 * Explanation 2:
 *
 *  For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 *  For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 *
 */
public class SubMatrixSumQueries
{

    /**
     * TC = O(n.m) + O(n.m) + O(q)
     */
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int m = A.length, n = A[0].length;
        int mod = 1000000007;
        // calculate the prefix row sum
        for (int i=0;i<m;i++) {
            int prefix_row_sum = 0;
            for (int j=0;j<n;j++) {
                prefix_row_sum = (((prefix_row_sum + A[i][j]) % mod) + mod) % mod;
                A[i][j] = prefix_row_sum % mod;
            }
        }
        // calculate the prefix column sum
        for (int i=0;i<n;i++) {
            int prefix_col_sum = 0;
            for (int j=0;j<m;j++) {
                prefix_col_sum = (((prefix_col_sum + A[j][i]) % mod) + mod) % mod;
                A[j][i] = prefix_col_sum % mod;
            }
        }
        int[] submatrix_sum = new int[B.length];
        for (int i=0;i<B.length;i++) {
            int top = B[i] - 1, left = C[i] - 1;
            int bottom = D[i] - 1, right = E[i] - 1;
            int br = A[bottom][right] % mod, tr = 0;
            int bl = 0, tl = 0;
            if (top > 0) {
                tr = A[top-1][right] % mod;
            }
            if (left > 0) {
                bl = A[bottom][left-1] % mod;
            }
            if (top > 0 && left > 0) {
                tl = A[top-1][left-1] % mod;
            }
            int sum = (((br - tr) % mod) + mod) % mod;
            sum = (((sum - bl) % mod) + mod) % mod;
            sum = (((sum + tl) % mod) + mod) % mod;
            submatrix_sum[i] = sum;
        }
        return submatrix_sum;
    }

    /**
     * TC = O(n.m) + O(q.n)
     * SC = O(n.m)
     */
    public int[] solve1(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length, m = A[0].length;
        int mod = 1000000007;
        // calculate the prefix row sum of A
        int[][] prefix_row_sum = new int[n][m];
        for (int i=0;i<n;i++) {
            prefix_row_sum[i][0] = A[i][0];
            for (int j=1;j<m;j++) {
                prefix_row_sum[i][j] = (((prefix_row_sum[i][j-1] + A[i][j]) % mod) + mod) % mod;
            }
        }

        int[] ans = new int[B.length];
        // for each query
        for (int i=0;i<B.length;i++) {
            int sum = 0;
            int top = B[i]-1, left = C[i]-1, bottom = D[i]-1, right = E[i]-1;
            for (int j=top;j<=bottom;j++) {
                sum = (((sum + prefix_row_sum[j][right]) % mod) + mod) % mod;
                if (left > 0) {
                    sum = (((sum - prefix_row_sum[j][left-1]) % mod) + mod) % mod;
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    /**
     * TC = O(n.m) + O(q)
     * SC = O(n.m)
     */
    public static int[] solve2(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length, m = A[0].length;
        int mod = 1000000007;

        // calculate the prefix sum for all elements in A i.e.
        // prefix_sum(i,j) stores the sum of all elements from (0,0) to (i,j)
        int[][] prefix_sum = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                prefix_sum[i][j] = A[i][j];
                if (i > 0) {
                    prefix_sum[i][j] = (((prefix_sum[i][j] + prefix_sum[i-1][j]) % mod) + mod) % mod;
                }
                if (j > 0) {
                    prefix_sum[i][j] = (((prefix_sum[i][j] + prefix_sum[i][j-1]) % mod) + mod) % mod;
                }
                if (i > 0 && j > 0) {
                    prefix_sum[i][j] = (((prefix_sum[i][j] - prefix_sum[i-1][j-1]) % mod) + mod) % mod;
                }
            }
        }

        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            int top = B[i] - 1, left = C[i] - 1, bottom = D[i] - 1, right = E[i] - 1;
            int sum = prefix_sum[bottom][right];
            if (top > 0) {
                sum = (((sum - prefix_sum[top-1][right]) % mod) + mod) % mod;
            }
            if (left > 0) {
                sum = (((sum - prefix_sum[bottom][left-1]) % mod) + mod) % mod;
            }
            if (top > 0 && left > 0) {
                sum = (((sum + prefix_sum[top-1][left-1]) % mod) + mod) % mod;
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] B = {1,2};
        int[] C = {1,2};
        int[] D = {2,3};
        int[] E = {2,3};
        System.out.println(Arrays.toString(solve2(A,B,C,D,E)));
    }
}

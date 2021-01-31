package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 * You are given an array A (containing only 0 and 1) as element of N length.
 *
 * Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.
 *
 *
 * Problem Constraints
 *
 * 1<=N,Q<=100000
 * 1<=L<=R<=N
 *
 *
 *
 * Input Format
 *
 * First argument contains the array of size N containing 0 and 1 only.
 * Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.
 *
 *
 *
 * Output Format
 *
 * Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.
 *
 *
 *
 * Example Input
 *
 * A=[1,0,0,0,1]
 * B=[ [2,4],
 *     [1,5],
 *     [3,5] ]
 *
 *
 *
 * Example Output
 *
 * [[0 3]
 * [0 3]
 * [1 2]]
 *
 *
 *
 * Example Explanation
 *
 * In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1.
 * For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3.
 * Similarly for other queries.
 */
public class XORQueries
{

    /**
     * TC = O(Q * n) = O(n^2) in worst case
     */
    public static int[][] solve(int[] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        int[][] res = new int[m][2];
        for (int i=0;i<m;i++) {
            int left = B[i][0] - 1;
            int right = B[i][1] - 1;
            int count = 0;
            for (int j=left;j<=right;j++) {
                if (A[j] == 1) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                res[i][0] = 1;
            } else {
                res[i][0] = 0;
            }
            int unset_bits = (right - left + 1) - count;
            res[i][1] = unset_bits;
        }
        return res;
    }

    /**
     * TC = O(n) + O(q) = O(n), SC = O(n)
     */
    public static int[][] solve1(int[] A, int[][] B) {
        int n = A.length, m = B.length;
        int[] prefix_xor = new int[n];
        int[] freq_ones = new int[n];
        prefix_xor[0] = A[0];
        freq_ones[0] = A[0];
        // create prefix xor and frequency array of zeroes
        for (int i=1;i<n;i++) {
            prefix_xor[i] = prefix_xor[i-1] ^ A[i];
            freq_ones[i] = freq_ones[i-1] + A[i];
        }
        int[][] res = new int[m][2];
        // calculate the xor and no. of zeroes for each query
        for (int i=0;i<m;i++) {
            int left = B[i][0] - 1, right = B[i][1] - 1;
            if (left > 0) {
                res[i][0] = prefix_xor[right] ^ prefix_xor[left-1];
                res[i][1] = (right - left + 1) - (freq_ones[right] - freq_ones[left-1]);
            } else {
                res[i][0] = prefix_xor[right];
                res[i][1] = (right - left + 1) - freq_ones[right];
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {1,1,0,1,0,0,1,1,0,1};
        int[][] B = {
                {5,10},
                {4,8},
                {2,9},
                {1,10}
        };
        System.out.println(Arrays.deepToString(solve1(A, B)));
    }
}

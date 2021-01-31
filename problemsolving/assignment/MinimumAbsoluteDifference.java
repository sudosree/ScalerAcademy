package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 *
 * Output Format
 *
 * Return the minimum value of | A[i] - A[j] |.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 *
 * Output 2:
 *
 *  6
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The absolute difference between any two adjacent elements is 1, which is the minimum value.
 *
 * Explanation 2:
 *
 *  The minimum value is 6 (|11 - 5| or |17 - 11|).
 */
public class MinimumAbsoluteDifference
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length-1;i++) {
            for (int j=i+1;j<A.length;j++) {
                int diff = Math.abs(A[i] - A[j]);
                min = Math.min(min, diff);
            }
        }
        return min;
    }

    /**
     * TC = O(nlogn), SC = O(1)
     */
    private static int solve1(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<A.length;i++) {
            int diff = A[i] - A[i-1];
            min = Math.min(min, diff);
        }
        return min;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve1(A));
    }
}

package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * You are given an integer array A having N integers.
 *
 * You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the minimum length.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [0, 1, 15, 25, 6, 7, 30, 40, 50]
 *
 * Input 2:
 *
 *  A = [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
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
 *  The smallest subarray to be sorted to make the whole array sorted =  A[3..6] i.e, subarray lying between positions 3 and 6.
 *
 * Explanation 2:
 *
 *  The smallest subarray to be sorted to make the whole array sorted =  A[4..9] i.e, subarray lying between positions 4 and 9.
 */
public class SortTheUnsortedArray
{

    /**
     * TC = O(nlogn), SC = O(n)
     */
    private static int solve(int[] A) {
        int[] copy = Arrays.copyOf(A, A.length);
        Arrays.sort(copy);
        int l = A.length-1, r = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] != copy[i]) {
                l = Math.min(l,i);
                r = Math.max(r,i);
            }
        }
        return l == A.length-1 ? 0 : r-l+1;
    }

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve1(int[] A) {
        int l = A.length-1, r = 0;
        for (int i=0;i<A.length-1;i++) {
            for (int j=i+1;j<A.length;j++) {
                if (A[j] < A[i]) {
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }
        return l == A.length-1 ? 0 : r-l+1;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve2(int[] A) {
        int l = A.length-1, r = 0;
        for (int i=0;i<A.length-1;i++) {
            // the current element should be lesser than its next element
            // this condition is violated here
            if (A[i] > A[i+1]) {
                l = i;
                break;
            }
        }

        for (int i=A.length-1;i>0;i--) {
            // the current element should be greater than its previous element
            // this condition is violated here
            if (A[i] < A[i-1]) {
                r = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // find the min and max element in the subarray
        for (int i=l;i<=r;i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        // check if the min in the subarray A[l..r] is greater than all of its elements in the left side A[0..l-1]
        for (int i=0;i<l;i++) {
            if (A[i] > min) {
                l = i;
                break;
            }
        }
        // check if the max in the subarray A[l..r] is lesser than all of its elements in the right side A[r+1..n-1]
        for (int i=A.length-1;i>r;i--) {
            if (A[i] < max) {
                r = i;
                break;
            }
        }
        return l == A.length-1 ? 0 : r - l +1;
    }

    public static void main(String[] args)
    {
        int[] A = {1,3,4,7,6,2,12,10,9,11};
        System.out.println(solve2(A));
    }
}

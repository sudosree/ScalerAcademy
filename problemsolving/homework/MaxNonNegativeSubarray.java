package problemsolving.homework;

import java.util.*;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 * Find and return the required subarray.
 *
 * NOTE:
 *
 *     1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 *     2. If there is still a tie, then return the segment with minimum starting index.
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains an integer array A, of length N.
 *
 * Output Format:
 *
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 *
 * Constraints:
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 *
 * Examples:
 *
 * Input 1:
 *     A = [1, 2, 5, -7, 2, 3]
 *
 * Output 1:
 *     [1, 2, 5]
 *
 * Explanation 1:
 *     The two sub-arrays are [1, 2, 5] [2, 3].
 *     The answer is [1, 2, 5] as its sum is larger than [2, 3].
 *
 * Input 2:
 *     A = [10, -1, 2, 3, -4, 100]
 *
 * Output 2:
 *     [100]
 *
 * Explanation 2:
 *     The three sub-arrays are [10], [2, 3], [100].
 *     The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubarray
{
    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int[] maxSet(int[] A) {
        long max_sum = 0;
        int max_len = 0;
        int start = -1, end = -1;
        for (int i=0;i<A.length;i++) {
            long curr_sum = 0;
            for (int j=i;j<A.length;j++) {
                if (A[j] < 0) {
                    break;
                }
                curr_sum += A[j];
                int curr_len = j - i + 1;
                if (curr_sum > max_sum) {
                    start = i;
                    end = j;
                    max_sum = curr_sum;
                    max_len = curr_len;
                } else if (curr_sum == max_sum) {
                    if (curr_len > max_len) {
                        start = i;
                        end = j;
                        max_len = curr_len;
                    }
                }
            }
        }
        // if all are negative elements
        if (start == -1 && end == -1) {
            return new int[]{};
        }
        int[] res = new int[end-start+1];
        for (int i=start,j=0;i<=end;i++,j++) {
            res[j] = A[i];
        }
        return res;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    public int[] maxset(int[] A) {
        long max_sum = 0, curr_sum = 0;
        int max_len = 0, curr_len = 0;
        int i=0, j=0;
        int start = -1, end = -1;
        while (j < A.length) {
            if (A[j] < 0) {
                i = j+1;
                j++;
                curr_sum = 0;
                continue;
            }
            curr_sum += A[j];
            curr_len = j-i+1;
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                max_len = curr_len;
                start = i;
                end = j;
            } else if (curr_sum == max_sum) {
                if (curr_len > max_len) {
                    max_len = curr_len;
                    start = i;
                    end = j;
                }
            }
            j++;
        }
        if (start == -1) {
            return new int[]{};
        }
        int[] ans = new int[end-start+1];
        for (int k=0;k<ans.length;k++) {
            ans[k] = A[start++];
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {-1,-1,-1,-1,-1};
        System.out.println(Arrays.toString(maxSet(A)));
    }
}

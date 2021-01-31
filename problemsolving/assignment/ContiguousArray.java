package problemsolving.assignment;

import java.util.*;

/**
 * Given an array of integers A consisting of only 0 and 1.
 *
 * Find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 * Output Format
 *
 * Return the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Constraints
 *
 * 1 <= length of the array <= 100000
 * 0 <= A[i] <= 1
 *
 * For Example
 *
 * Input 1:
 *     A = [1, 0, 1, 0, 1]
 * Output 1:
 *     4
 *     Explanation 1:
 *         Subarray from index 0 to index 3 : [1, 0, 1, 0]
 *         Subarray from index 1 to index 4 : [0, 1, 0, 1]
 *         Both the subarrays have equal number of ones and equal number of zeroes.
 *
 * Input 2:
 *     A = [1, 1, 1, 0]
 * Output 2:
 *     2
 */
public class ContiguousArray
{
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, prefixSum = 0;
        for (int i=0;i<A.length;i++) {
            prefixSum += A[i] == 0 ? -1 : 1;
            if (prefixSum == 0) {
                int currLen = i+1;
                maxLen = Math.max(maxLen, currLen);
            } else if (map.containsKey(prefixSum)) {
                int currLen = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] A = {0,0,1,0,0,0,1,1};
        System.out.println(solve(A));
    }
}

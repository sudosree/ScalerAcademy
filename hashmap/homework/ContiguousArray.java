package hashmap.homework;

import java.util.HashMap;
import java.util.Map;

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
    private static int solve1(int[] A) {
        int subArrayLen = 0;
        int cumulativeSum;
        for (int i=0;i<A.length-1;i++) {
            if (A[i] == 1) {
                cumulativeSum = 1;
            } else {
                cumulativeSum = -1;
            }
            for (int j=i+1;j<A.length;j++) {
                if (A[j] == 1) {
                    cumulativeSum += 1;
                } else {
                    cumulativeSum += -1;
                }
                if (cumulativeSum == 0) {
                    subArrayLen = Math.max(subArrayLen, j-i+1);
                }
            }
        }
        return subArrayLen;
    }

    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSubArrayLen = 0;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            count += (A[i] == 1) ? 1 : -1;
            // no. of 0s and 1s are equal from index 0 to current index i
            if (count == 0) {
                maxSubArrayLen = i+1;
            }
            // no. of 0s and 1s are equal between the current index i and the index map.get(count)
            else if (map.containsKey(count)) {
                int currSubArrayLen = i-map.get(count);
                maxSubArrayLen = Math.max(maxSubArrayLen, currSubArrayLen);
            } else {
                map.put(count, i);
            }
        }
        return maxSubArrayLen;
    }

    public static void main(String[] args)
    {
        int[] A = {1,1,1,0,1,0,0,0,1,0};
        System.out.println(solve(A));
    }
}

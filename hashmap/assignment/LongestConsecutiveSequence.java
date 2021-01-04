package hashmap.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 *
 * Output Format
 *
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 *
 * Input 2:
 *
 * A = [2, 1]
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
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The set of consecutive elements will be [1, 2, 3, 4].
 *
 * Explanation 2:
 *
 *  The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSequence
{
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            map.put(A[i], i);
        }
        int ans = 0;
        for (int i=0;i<A.length;i++) {
            // first check if A[i] can be the start of a sequence
            if (!map.containsKey(A[i]-1)) {
               int count = 1;   // sequence with count 1
               // now check how far you can go
               int start = A[i];
               while (map.containsKey(++start)) {
                   count++;
               }
               ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    private static int solve1(int[] A) {
        int maxLen = 1, n = A.length;
        int currLen = 1;
        Arrays.sort(A);
        for (int i=1;i<n;i++) {
            // if duplicate value then ignore
            if (A[i] != A[i-1]) {
                // if the current element contributes to the existing length or not
                if (A[i] == A[i-1]+1) {
                    currLen++;
                    maxLen = Math.max(maxLen,currLen);
                } else {
                    currLen = 1;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(solve1(A));
    }
}

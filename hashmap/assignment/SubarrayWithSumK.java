package hashmap.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 *
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [2, 3]
 *
 * Output 2:
 *
 *  -1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 *
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 */
public class SubarrayWithSumK
{

    /**
     * Time complexity - O(n^2)
     * Space Complexity - O(1)
     */
    private static int[] solve(int[] A, int B)
    {
        for (int start = 0; start < A.length; start++) {
            long sum = A[start];
            if (sum == B) {
                return new int[]{ A[start] };
            }
            for (int end = start + 1; end < A.length; end++) {
                sum += A[end];
                if (sum == B) {
                    int[] ans = new int[end - start + 1];
                    for (int i = start, j = 0; i <= end && j < ans.length; i++, j++) {
                        ans[j] = A[i];
                    }
                    return ans;
                }
            }
        }
        return new int[]{ -1 };
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     */
    private static int[] solve2(int[] A, int B)
    {
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        for (int start = 0; start < prefixSum.length; start++) {
            for (int end = start; end < prefixSum.length; end++) {
                if (start == 0) {
                    if (prefixSum[end] == B) {
                        int[] ans = new int[end - start + 1];
                        for (int i = start; i <= end; i++) {
                            ans[i] = A[i];
                        }
                        return ans;
                    }
                } else {
                    long sum = prefixSum[end] - prefixSum[start - 1];
                    if (sum == B) {
                        int[] ans = new int[end - start + 1];
                        for (int i = start, j = 0; i <= end && j < ans.length; i++, j++) {
                            ans[j] = A[i];
                        }
                        return ans;
                    }
                }
            }
        }
        return new int[]{ -1 };
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n) + O(n)
     */
    private static int[] solve3(int[] A, int B) {
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        Map<Long, Integer> prefixMap = new HashMap<>();
        // required if there is a subarray whose sum is equal to B starting from 0
        prefixMap.put(0L, -1);
        for (int end=0; end<prefixSum.length; end++) {

            // this part is equal to diff k problem where you have to check whether sum == prefixSum[end] - prefixSum[start-1]
            // i.e. you have to check whether prefixSum[start-1] == prefixSum[end] - sum
            // i.e. whether prefixSum[start-1] is present in the hashmap or not

            if (prefixMap.containsKey(prefixSum[end]-B)) {
                int start = prefixMap.get(prefixSum[end]-B);
                int[] ans = new int[end-start];
                for (int j=start+1,k=0; j<=end && k<ans.length; j++,k++) {
                    ans[k] = A[j];
                }
                return ans;
            } else {
                prefixMap.put(prefixSum[end], end);
            }
        }
        return new int[]{-1};
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int[] solve4(int[] A, int B) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        // required if there is a subarray whose sum is equal to B starting from 0
        prefixMap.put(0L, -1);
        long prefixSum = 0;
        for (int end=0; end<A.length; end++) {
            prefixSum += A[end];

            // this part is equal to diff k problem where you have to check whether sum == prefixSum[end] - prefixSum[start-1]
            // i.e. you have to check whether prefixSum[start-1] == prefixSum[end] - sum
            // i.e. whether prefixSum[start-1] is present in the hashmap or not

            if (prefixMap.containsKey(prefixSum-B)) {
                int start = prefixMap.get(prefixSum-B);
                int[] ans = new int[end-start];
                for (int i=start+1,j=0; i<=end && j<ans.length; i++,j++) {
                    ans[j] = A[i];
                }
                return ans;
            } else {
                prefixMap.put(prefixSum, end);
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args)
    {
        int[] A = { 1,4,20,3,10,20 };
        int B = 33;
        int[] ans = solve4(A, B);
        for (int i = 0; i < ans.length; i++)
        {
            System.out.println(ans[i]);
        }
    }
}

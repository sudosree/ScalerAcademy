package dynamicprogramming.assignment;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    /**
     * TC = O(nlogn + n^2) = O(n^2)
     */
    public int solve(int[][] A) {
        Arrays.sort(A, new MyComparator());
        int[] dp = new int[A.length];
        // length of the longest increasing subsequence till 0th index is always 1
        dp[0] = 1;
        int max = 1;
        for (int i=1;i<A.length;i++) {
            // minimum longest increasing subsequence till ith index is the number itself
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (A[j][1] < A[i][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] d1, int[] d2) {
            if (d1[0] < d2[0]) {
                return -1;
            }
            if (d1[0] > d2[0]) {
                return 1;
            }
            // if heights are same sort them in descending order wrt width
            if (d1[1] == d2[1]) {
                return 0;
            }
            return d1[1] < d2[1] ? 1 : -1;
        }
    }

    /**
     * TC = O(nlogn + n^2) = O(n^2)
     */
    public int solve1(int[][] A) {
        Arrays.sort(A, new MyComparator1());
        int[] dp = new int[A.length];
        // length of the longest increasing subsequence till 0th index is always 1
        dp[0] = 1;
        int max = 1;
        for (int i=1;i<A.length;i++) {
            // minimum longest increasing subsequence till ith index is the number itself
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (A[j][1] < A[i][1] && A[j][0] != A[i][0] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static class MyComparator1 implements Comparator<int[]> {

        @Override
        public int compare(int[] d1, int[] d2) {
            if (d1[0] == d2[0]) {
                return 0;
            }
            return d1[0] < d2[0] ? -1 : 1;
        }
    }
}

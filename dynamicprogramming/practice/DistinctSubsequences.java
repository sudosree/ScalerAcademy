package dynamicprogramming.practice;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        return numDistinctHelper(s, t, s.length()-1, t.length()-1);
    }

    private int numDistinctHelper(String s, String t, int i, int j) {
        // found a match
        if (i < 0 && j < 0) {
            return 1;
        }
        // found a match
        if (j < 0) {
            return 1;
        }
        // didn't find a match
        if (i < 0) {
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            int match = numDistinctHelper(s, t, i-1, j-1);
            int mismatch = numDistinctHelper(s, t, i-1, j);
            return match + mismatch;
        }
        return numDistinctHelper(s, t, i-1, j);
    }

    private int[][] dp;

    public int numDistinctMemo(String s, String t) {
        int n = s.length(), m = t.length();
        dp = new int[n+1][m+1];
        for (int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        return numDistinctHelperMemo(s, t, s.length(), t.length());
    }

    private int numDistinctHelperMemo(String s, String t, int i, int j) {
        // found a match
        if (i == 0 && j == 0) {
            return 1;
        }
        // found a match
        if (j == 0) {
            return 1;
        }
        // didn't find a match
        if (i == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i-1) == t.charAt(j-1)) {
            int match = numDistinctHelperMemo(s, t, i-1, j-1);
            int mismatch = numDistinctHelperMemo(s, t, i-1, j);
            dp[i][j] = match + mismatch;
        } else {
            dp[i][j] = numDistinctHelperMemo(s, t, i-1, j);
        }
        return dp[i][j];
    }

    /**
     * TC = O(n*m), SC = O(n*m)
     * @param s
     * @param t
     * @return
     */
    public int numDistinctDP(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i=1;i<n+1;i++) {
            dp[i][0] = 1;
        }
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    int match = dp[i-1][j-1];
                    int mismatch = dp[i-1][j];
                    dp[i][j] = match + mismatch;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public int numDistinctDPS(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        prev[0] = 1;
        curr[0] = 1;
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;

        }
        return prev[m];
    }
}

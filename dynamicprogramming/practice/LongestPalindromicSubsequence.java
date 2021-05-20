package dynamicprogramming.practice;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        return lps(s, 0, s.length()-1);
    }

    private int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + lps(s, i+1, j-1);
        }
        return Math.max(lps(s, i, j-1), lps(s, i+1, j));
    }

    /**
     * TC = O(n^2), SC = O(n^2)
     */
    public int longestPalindromeSubseq1(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        // first fill the cell for string of length 1,
        // string of length 1 is a valid palindrome
        for (int i=1;i<n+1;i++) {
            dp[i][i] = 1;
        }

        // fill the cell for string of length 2
        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                dp[i][i+1] = 2;
            } else {
                dp[i][i+1] = 1;
            }
        }

        // fill the cell for string of remaining lengths
        for (int l=3;l<n+1;l++) {
            int i=1, j = l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
                j++;
                i++;
            }
        }
        return dp[1][n];
    }

    private int[][] dp;

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        dp = new int[n][n];
        return lps1(s, 0, n-1);
    }

    private int lps1(String s, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + lps1(s, i+1, j-1);
        } else {
            dp[i][j] = Math.max(lps1(s, i, j-1), lps1(s, i+1, j));
        }
        return dp[i][j];
    }
}

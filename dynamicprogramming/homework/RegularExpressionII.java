package dynamicprogramming.homework;

public class RegularExpressionII {

    public int isMatch(final String A, final String B) {
        int n = A.length(), m = B.length();
        boolean[][] dp = new boolean[n+1][m+1];
        // empty string matches with empty pattern
        dp[0][0] = true;

        // empty pattern with non empty string will give false
        for (int i=1;i<n+1;i++) {
            dp[i][0] = false;
        }

        // empty string with non empty pattern
        for (int i=2;i<m+1;i+=2) {
            if (B.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (B.charAt(j-1) == '*') {
                    if (B.charAt(j-2) != '.' && A.charAt(i-1) != B.charAt(j-2)) {
                        dp[i][j] = dp[i][j-2];
                    } else if (B.charAt(j-2) == '.' || A.charAt(i-1) == B.charAt(j-2)) {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    public int isMatch1(final String A, final String B) {
        int n = A.length(), m = B.length();
        int[][] dp = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return isMatchHelper(A, B, n-1, m-1, dp) ? 1 : 0;
    }

    private boolean isMatchHelper(String s, String p, int i, int j, int[][] dp) {
        // empty pattern matches with empty string
        if (i < 0 && j < 0) {
            return true;
        }
        // empty pattern cannot match with non empty string
        if (j < 0) {
            return false;
        }
        if (i < 0) {
            if (p.charAt(j) == '*') {
                return isMatchHelper(s, p, i, j-1, dp);
            }
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            dp[i][j] = isMatchHelper(s, p, i-1, j-1, dp) ? 1 : 0;
        } else if (p.charAt(j) == '*') {
            if (p.charAt(j-1) != '.' && p.charAt(j-1) != s.charAt(i)) {
                dp[i][j] = isMatchHelper(s, p, i, j-2, dp) ? 1 : 0;
            } else if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)) {
                dp[i][j] = (isMatchHelper(s, p, i, j-2, dp) || isMatchHelper(s, p, i-1, j-2, dp) || isMatchHelper(s, p, i-1, j, dp)) ? 1 : 0;
            }
        }
        return dp[i][j] == 1 ? true : false;
    }
}

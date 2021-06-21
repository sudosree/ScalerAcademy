package dynamicprogramming.homework;

public class RegularExpressionII {

    public int isMatch(final String A, final String B) {
        int n = A.length(), m = B.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //empty string with empty pattern
        dp[0][0] = true;

        for (int i=2;i<m+1;i+=2) {
            if (B.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (B.charAt(j-1) == '*') {
                    if (A.charAt(i-1) == B.charAt(j-2) || B.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    private int[][] dp;

    public int isMatch1(final String A, final String B) {
        int n = A.length(), m = B.length();
        dp = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return isMatchHelper(A, B, n-1, m-1, n, m) ? 1 : 0;
    }

    private boolean isMatchHelper(String s, String p, int i, int j, int n, int m) {
        // string and pattern are empty, so there is a match
        if (i < 0 && j < 0) {
            return true;
        }
        // pattern is empty so no match
        if (j < 0) {
            return false;
        }
        // string is empty
        if (i < 0) {
            // consider 0 occurrence of (j-1)th character
            if (p.charAt(j) == '*') {
                return isMatchHelper(s, p, i, j-2, n, m);
            }
            // the jth character is either a character or '.'
            return false;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            dp[i][j] = isMatchHelper(s, p, i-1, j-1, n, m) ? 1 : 0;
        } else if (p.charAt(j) == '*') {
            if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                boolean zeroOccur = isMatchHelper(s, p, i, j-2, n, m);
                boolean oneOccur = isMatchHelper(s, p, i-1, j, n, m);
                dp[i][j] = (zeroOccur || oneOccur) ? 1 : 0;
            } else {
                dp[i][j] = isMatchHelper(s, p, i, j-2, n, m) ? 1 : 0;
            }
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}

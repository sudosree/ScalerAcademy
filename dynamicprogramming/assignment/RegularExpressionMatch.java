package dynamicprogramming.assignment;

public class RegularExpressionMatch {

    public static boolean isMatch(String s, String p) {
        return isMatchHelper(s.toCharArray(), p.toCharArray(), s.length()-1, p.length()-1);
    }

    private static boolean isMatchHelper(char[] s, char[] p, int i, int j) {
        // empty pattern matches with empty string
        if (i < 0 && j < 0) {
            return true;
        }
        // empty pattern doesn't match with non empty string
        if (j < 0) {
            return false;
        }
        // empty string with non empty pattern
        if (i < 0) {
            if (p[j] == '*') {
                return isMatchHelper(s, p, i, j-1);
            }
            // if p[j] == '?' or if p[j] is any character
            return false;
        }
        if (p[j] == '*') {
            return isMatchHelper(s, p, i, j-1) || isMatchHelper(s, p, i-1, j);
        }
        if (s[i] == p[j] || p[j] == '?') {
            return isMatchHelper(s, p, i-1, j-1);
        }
        // if s[i] != p[j]
        return false;
    }

    private static int[][] dp;

    public static int isMatch1(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return isMatchHelper1(s, p, n-1, m-1) ? 1 : 0;
    }

    private static boolean isMatchHelper1(String s, String p, int i, int j) {
        // empty string matches with empty pattern
        if (i < 0 && j < 0) {
            return true;
        }
        // empty string with non-empty pattern
        if (i < 0) {
            if (p.charAt(j) == '*') {
                return isMatchHelper1(s, p, i, j-1);
            }
            return false;
        }
        // non empty string with empty pattern
        if (j < 0) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = isMatchHelper1(s, p, i-1, j-1) ? 1 : 0;
        } else if (p.charAt(j) == '*') {
            dp[i][j] = (isMatchHelper1(s, p, i-1, j) || isMatchHelper1(s, p, i, j-1)) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }

    /**
     * TC = O(m*n), SC = O(m*n)
     */
    public static boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // empty string with empty pattern
        dp[0][0] = true;
        // empty pattern with non empty string
        for (int i=1;i<m+1;i++) {
            dp[i][0] = false;
        }
        // empty string with non empty pattern
        for (int i=1;i<n+1;i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }
        for (int i=1;i<m+1;i++) {
            for (int j=1;j<n+1;j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "abaa";
        String p = "a**?a";
        System.out.println(isMatch(s,p));
    }
}

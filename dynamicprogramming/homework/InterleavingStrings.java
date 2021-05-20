package dynamicprogramming.homework;

public class InterleavingStrings {

    /**
     * TC = O(nm), SC = O(nm)
     * @param A
     * @param B
     * @param C
     * @return
     */
    public int isInterleave(String A, String B, String C) {
        int n = A.length(), m = B.length(), l = C.length();
        boolean[][] dp = new boolean[n+1][m+1];

        if (l != n+m) {
            return 0;
        }

        // if A and B are empty then C is also empty and C is an interleaving string of A and B
        dp[0][0] = true;

        // when A is empty, B is not empty
        for (int i=1,k=1; i<m+1; i++,k++) {
            if (B.charAt(i-1) == C.charAt(k-1)) {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }

        // when B is empty, A is not empty
        for (int i=1,k=1; i<n+1; i++,k++) {
            if (A.charAt(i-1) == C.charAt(k-1)) {
                dp[i][0] = dp[i-1][0];
            } else {
                dp[i][0] = false;
            }
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                int k = i+j;
                if (A.charAt(i-1) == C.charAt(k-1) && B.charAt(j-1) == C.charAt(k-1)) {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (A.charAt(i-1) == C.charAt(k-1)) {
                    dp[i][j] = dp[i-1][j];
                } else if (B.charAt(j-1) == C.charAt(k-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    private int[][] dp;

    public int isInterleave1(String A, String B, String C) {
        int n = A.length(), m = B.length(), l = C.length();
        dp = new int[n][m];

        if (l != n+m) {
            return 0;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return isInterleaveHelper(A, B, C, 0, 0, 0) ? 1 : 0;
    }

    private boolean isInterleaveHelper(String A, String B, String C, int i, int j, int k) {
        // if string A is processed, check the remaining string of B
        // matches with the remaining string of C
        if (i == A.length()) {
            return B.substring(j).equals(C.substring(k));
        }
        // if string B is processed, check the remaining string of A
        // matches with the remaining string of C
        if (j == B.length()) {
            return A.substring(i).equals(C.substring(k));
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (A.charAt(i) == C.charAt(k) && B.charAt(j) == C.charAt(k)) {
            dp[i][j] = (isInterleaveHelper(A, B, C, i+1, j, k+1) || isInterleaveHelper(A, B, C, i, j+1, k+1)) ? 1 : 0;
        } else if (A.charAt(i) == C.charAt(k)) {
            dp[i][j] = isInterleaveHelper(A, B, C, i+1, j, k+1) ? 1 : 0;
        } else if (B.charAt(j) == C.charAt(k)) {
            dp[i][j] = isInterleaveHelper(A, B, C, i, j+1, k+1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}

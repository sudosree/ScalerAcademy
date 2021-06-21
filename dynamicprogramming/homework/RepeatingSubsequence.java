package dynamicprogramming.homework;

import java.util.Arrays;

public class RepeatingSubsequence {

    public int anytwo(String A) {
        int len = lcs(A, A, A.length()-1, A.length()-1);
        return len >= 2 ? 1 : 0;
    }

    private int lcs(String A, String B, int i, int j) {
        // if one of the string becomes empty then there is no common subsequence
        if (i < 0 || j < 0) {
            return 0;
        }
        if (A.charAt(i) == B.charAt(j) && i != j) {
            return 1 + lcs(A, B, i-1, j-1);
        }
        return Math.max(lcs(A, B, i, j-1), lcs(A, B, i-1, j));
    }

    private int[][] lcs;

    public int anytwo1(String A) {
        int n = A.length();
        lcs = new int[n+1][n+1];
        for (int i=0;i<n+1;i++) {
            Arrays.fill(lcs[i], -1);
        }
        int len = lcsHelper(A, A, n, n);
        return len >= 2 ? 1 : 0;
    }

    private int lcsHelper(String A, String B, int i, int j) {
        // if one of the string becomes empty then there is no common subsequence
        if (i == 0 || j == 0) {
            return 0;
        }
        if (lcs[i][j] > -1) {
            return lcs[i][j];
        }
        if (A.charAt(i-1) == B.charAt(j-1) && i != j) {
            lcs[i][j] = 1 + lcsHelper(A, B, i-1, j-1);
        } else {
            lcs[i][j] = Math.max(lcsHelper(A, B, i, j-1), lcsHelper(A, B, i-1, j));
        }
        return lcs[i][j];
    }

    /**
     * TC = O(n^2), SC = O(n^2)
     */
    public int anytwo2(String A) {
        int n = A.length();
        int[][] lcs = new int[n+1][n+1];

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<n+1;j++) {
                if (A.charAt(i-1) == A.charAt(j-1) && i != j) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[n][n] >= 2 ? 1 : 0;
    }
}

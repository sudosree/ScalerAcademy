package dynamicprogramming.practice;

import java.util.Arrays;

public class CheckSubsequenceExist {

    private static boolean checkSubseq(String s, String t) {
        return checkSubseqHelper(s, t, s.length()-1, t.length()-1);
    }

    private static boolean checkSubseqHelper(String s, String t, int i, int j) {
        // target string is successfully matched
        if (i < 0 && j < 0) {
            return true;
        }
        // if the target string becomes empty that means we
        // have successfully matched the target string
        if (j < 0) {
            return true;
        }
        // target string is not matched
        if (i < 0) {
            return false;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return checkSubseqHelper(s, t, i-1, j-1);
        }
        return checkSubseqHelper(s, t, i-1, j);
    }

    private static int[][] dp;

    private static boolean checkSubseqMemo(String s, String t) {
        int n = s.length(), m = t.length();
        dp = new int[n+1][m+1];
        for (int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        return checkSubseqMemoHelper(s, t, n, m) == 1;
    }

    private static int checkSubseqMemoHelper(String s, String t, int i, int j) {
        // if both the strings are empty, we found a match for string t
        if (i == 0 && j == 0) {
            return 1;
        }
        // if string t becomes empty, we found a match
        if (j == 0) {
            return 1;
        }
        // if string s becomes empty and string t doesn't that means
        // we didn't found a match for string t
        if (i == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // found a match for string t
        if (s.charAt(i-1) == t.charAt(j-1)) {
            dp[i][j] = checkSubseqMemoHelper(s, t, i-1, j-1);
        }
        // not found a match for string t
        else {
            dp[i][j] = checkSubseqMemoHelper(s, t, i-1, j);
        }
        return dp[i][j];
    }

    private static boolean checkSubseqDP(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        // when string s is empty but string t is not empty
        for (int i=1;i<m+1;i++) {
            dp[0][i] = false;
        }
        // when string s is not empty but string t is empty
        for (int i=1;i<n+1;i++) {
            dp[i][0] = true;
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String t = "bdfgh";
        System.out.println(checkSubseq(s, t));
        System.out.println(checkSubseqMemo(s, t));
        System.out.println(checkSubseqDP(s, t));
    }
}

package dynamicprogramming.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioningII {

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n+1][n+1];
        int[] minCuts = new int[n+1];

        // first calculate the valid palindrome s=matrix

        for (int i=1;i<n+1;i++) {
            pal[i][i] = true;
        }

        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                pal[i][i+1] = true;
            } else {
                pal[i][i+1] = false;
            }
        }

        for (int l=3; l<n+1; l++) {
            int i=1, j=l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    pal[i][j] = pal[i+1][j-1];
                } else {
                    pal[i][j] = false;
                }
                i++;
                j++;
            }
        }

        for (int i=1;i<n+1;i++) {
            // if the complete string is a palindrome
            // then no cut is reqd.
            if (pal[1][i]) {
                minCuts[i] = 0;
            } else {
                minCuts[i] = i-1;
                for (int j=1;j<=i;j++) {
                    if (pal[j][i]) {
                        minCuts[i] = Math.min(minCuts[i], 1 + minCuts[j-1]);
                    }
                }
            }

        }
        return minCuts[n];
    }

    private static boolean[][] pal;
    private static int[] dp;

    public static int minCut1(String A) {
        int n = A.length();
        pal = new boolean[n+1][n+1];
        for (int i=1;i<n+1;i++) {
            pal[i][i] = true;
        }
        for (int i=1;i<n;i++) {
            if (A.charAt(i-1) == A.charAt(i)) {
                pal[i][i+1] = true;
            }
        }
        for (int l=3;l<n+1;l++) {
            int i=1,j=l+i-1;
            while (j<n+1) {
                if (A.charAt(i-1) == A.charAt(j-1)) {
                    if (pal[i+1][j-1]) {
                        pal[i][j] = true;
                    }
                }
                j++;
                i++;
            }
        }

        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return minCutHelper(A, n-1);
    }

    private static int minCutHelper(String A, int end) {
        if (end < 0) {
            return 0;
        }
        if (dp[end] != -1) {
            return dp[end];
        }
        int min = A.length()-1;
        for (int start=end;start>=0;start--) {
            if (pal[start][end]) {
                min = Math.min(min, 1 + minCutHelper(A, start-1));
            }
        }
        dp[end] = min;
        return dp[end];
    }

    private int[] minCuts;

    public int minCut2(String s) {
        int n = s.length();
        pal = new boolean[n+1][n+1];
        minCuts = new int[n+1];

        // first calculate the pal array
        // string of length 1 is a palindrome
        for (int i=1;i<n+1;i++) {
            pal[i][i] = true;
        }
        // string of length 2
        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                pal[i][i+1] = true;
            } else {
                pal[i][i+1] = false;
            }
        }

        for (int l=3;l<n+1;l++) {
            int i=1,j=l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    pal[i][j] = pal[i+1][j-1];
                } else {
                    pal[i][j] = false;
                }
                i++;
                j++;
            }
        }

        Arrays.fill(minCuts, -1);
        return minCutsHelper(s, 1, n);
    }

    private int minCutsHelper(String s, int start, int end) {
        // base case
        // if there is only one character or if the
        // entire string is a palindrome
        if (start == end || pal[start][end]) {
            return 0;
        }
        if (minCuts[end] != -1) {
            return minCuts[end];
        }
        int cuts = end-1;
        for (int i=end; i>=start; i--) {
            if (pal[i][end]) {
                cuts = Math.min(cuts, 1 + minCutsHelper(s, start, i-1));
            }
            minCuts[end] = cuts;
        }
        return minCuts[end];
    }

    private int minCutsRec(String A) {
        return minCutsHelperRec(A, 0, A.length()-1);
    }

    private int minCutsHelperRec(String A, int start, int end) {
        // base case - if the complete string is a palindrome then
        // no cut is required or if there is only one character in the
        // string then no cut is reqd
        if (start == end || isPalindrome(A, start, end)) {
            return 0;
        }

        // min cuts in a string of length n = n-1
        int minCuts = A.length()-1;
        for (int i=end;i>=start;i--) {
            // if the string is a palindrome then add 1 to the min cut
            // and recursively check for the remaining string
            if (isPalindrome(A, i, end)) {
                int minCutsRemaining = 1 + minCutsHelperRec(A, start, i-1);
                minCuts = Math.min(minCuts, minCutsRemaining);
            }
        }
        return minCuts;
    }

    boolean isPalindrome(String A, int s, int e) {
        while (s < e) {
            if (A.charAt(s) != A.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdcab";
        System.out.println(minCut(s));
        System.out.println(minCut1(s));
    }
}

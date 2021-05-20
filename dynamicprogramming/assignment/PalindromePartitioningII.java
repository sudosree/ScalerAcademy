package dynamicprogramming.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioningII {

    public static int minCut(String A) {
        int n = A.length();
        boolean[][] pal = new boolean[n+1][n+1];
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

        // dp state to store the minimum no. of cuts till ith position
        int[] dp = new int[n+1];
        for (int i=1;i<n+1;i++) {
            // if the complete string from (0..i) is a palindrome
            // then minimum no. of cuts required is 0
            if (pal[1][i]) {
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j=1;j<=i;j++) {
                    if (pal[j][i]) {
                        min = Math.min(min, 1 + dp[j-1]);
                        dp[i] = min;
                    }
                }
            }
        }
        return dp[n];
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

    public static void main(String[] args) {
        String s = "abcdcab";
        System.out.println(minCut(s));
        System.out.println(minCut1(s));
    }
}

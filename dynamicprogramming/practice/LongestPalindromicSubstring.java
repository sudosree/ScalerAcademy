package dynamicprogramming.practice;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    /**
     * TC = O(n^2), SC = O(n^2)
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];

        for (int i=1; i<n+1; i++) {
            dp[i][i] = true;
        }
        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                dp[i][i+1] = true;
            } else {
                dp[i][i+1] = false;
            }
        }
        for (int l=3;l<n+1;l++) {
            int i=1, j=l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
                i++;
                j++;
            }
        }

        int maxLen = 0, start = 0;
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<n+1;j++) {
                if (dp[i][j]) {
                    if (maxLen < j-i+1) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=start;i<start+maxLen;i++) {
            sb.append(s.charAt(i-1));
        }
        return sb.toString();
    }

    private int start = 0, maxLen = 0;

    public String longestPalindrome1(String s) {
        for (int i=0; i<s.length(); i++) {
            expandAroundMiddle(s, i, i);
            expandAroundMiddle(s, i, i+1);
        }
        return s.substring(start, start+maxLen);
    }

    private void expandAroundMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            start = left+1;
            maxLen = right-left-1;
        }
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }
}

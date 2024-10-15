package dynamicprogramming.practice;

public class LongestPalindromeSubstring {

  public static String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    // first initialize the dp array with substring of length 1 to be true
    // as susbtring of length 1 is a palindrome
    for (int i=0; i<n; i++) {
      dp[i][i] = true;
    }
    // check substring of length 2
    for (int i=0; i<n-1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        dp[i][i+1] = true;
      }
    }

    // check substring of the remaining length
    for (int len=3; len<n+1; len++) {
      int i=0;
      int j=len+i-1;
      while (j < n) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i+1][j-1];
        } else {
          dp[i][j] = false;
        }
        i++;
        j++;
      }
    }

    // find the max length
    int maxLen = 0;
    int start = 0;
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        if (dp[i][j]) {
          int len = j-i+1;
          if (maxLen < len) {
            maxLen = len;
            start = i;
          }
        }
      }
    }

    // build the string
    StringBuilder sb = new StringBuilder();
    for (int i=start; i<start+maxLen; i++) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindrome(s));
  }
}

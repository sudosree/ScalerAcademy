package dynamicprogramming.homework;

import java.util.Arrays;

public class WaysToDecode {

    public int numDecodings2(String s) {
        // if the first character is 0, it cannot be decoded
        if (s.charAt(0) == '0') {
            return 0;
        }
        return helper(s, 0);
    }

    private int helper(String s, int i) {
        // if reached the end of the string
        if (i == s.length()) {
            return 1;
        }
        // if the string starts with 0, it cannot be decoded
        if (s.charAt(i) == '0') {
            return 0;
        }
        if(i == s.length()-1) {
            return 1;
        }
        // decode a string in two ways
        // decode it as a single character
        int ans = helper(s, i+1);
        // decode it as two characters
        int num = Integer.parseInt(s.substring(i, i+2));
        if (num <= 26) {
            ans += helper(s, i+2);
        }
        return ans;
    }

    public int numDecodings4(String s) {
        return helper2(s, 0);
    }

    private int helper2(String s, int pos) {
        // you have successfully decoded the string
        if (pos == s.length()) {
            return 1;
        }
        // no decoding is possible
        if (s.charAt(pos) == '0') {
            return 0;
        }
        // at a time you can either take a single character or two characters
        int one = helper2(s, pos+1);
        int two = 0;
        if (pos+1 < s.length()) {
            int num = Integer.parseInt(s.substring(pos, pos+2));
            if (num >= 10 && num <= 26) {
                two = helper2(s, pos+2);
            }
        }
        return one + two;
    }

    private int[] memo;

    public int numDecodings3(String s) {
        // if the first character is 0, it cannot be decoded
        if (s.charAt(0) == '0') {
            return 0;
        }
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper1(s, 0);
    }

    private int helper1(String s, int i) {
        // if reached the end of the string
        if (i == s.length()) {
            return 1;
        }
        // if the string starts with 0, it cannot be decoded
        if (s.charAt(i) == '0') {
            return 0;
        }
        if(i == s.length()-1) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // decode a string in two ways
        // decode it as a single character
        int ans = helper(s, i+1);
        // decode it as two characters
        int num = Integer.parseInt(s.substring(i, i+2));
        if (num <= 26) {
            ans += helper(s, i+2);
        }
        memo[i] = ans;
        return ans;
    }

    /**
     * TC = O(n), SC = O(1)
     * @param A
     * @return
     */
    public int numDecodings(String A) {
        // single digit 0 is not a valid decoding
        if (A.charAt(0) == '0') {
            return 0;
        }
        int n = A.length();
        int[] dp = new int[n+1];
        // to handle the two digit decoding
        dp[0] = 1;
        // this single digit decoding will be the valid case as we have handle the
        // single digit 0 case above
        dp[1] = 1;
        int mod = 1000000007;
        for (int i=2;i<n+1;i++) {
            if (A.charAt(i-1) != '0') {
                dp[i] = dp[i-1] % mod;
            }
            int twoDigit = Integer.parseInt(A.substring(i-2,i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % mod;
            }
        }
        return dp[n];
    }

    /**
     * TC = O(n), SC = O(1)
     * @param A
     * @return
     */
    public int numDecodings1(String A) {
        // single digit 0 is not a valid decoding
        if (A.charAt(0) == '0') {
            return 0;
        }
        int n = A.length();
        // to handle the two digit decoding
        int twoBack = 1;
        // this single digit decoding will be the valid case as we have handle the
        // single digit 0 case above
        int oneBack = 1;
        int mod = 1000000007;
        for (int i=1;i<n;i++) {
            int curr = 0;
            if (A.charAt(i) != '0') {
                curr = oneBack % mod;
            }
            int twoDigit = Integer.parseInt(A.substring(i-1,i+1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr = (curr + twoBack) % mod;
            }
            twoBack = oneBack;
            oneBack = curr;
        }
        return oneBack;
    }
}

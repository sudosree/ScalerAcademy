package dynamicprogramming.homework;

public class WaysToDecode {

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

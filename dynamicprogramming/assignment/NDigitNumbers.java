package dynamicprogramming.assignment;

public class NDigitNumbers {

    static int mod = 1000000007;

    public static int solve(int A, int B) {
        int ans = 0;
        for (int i=1;i<10;i++) {
            if (B - i >= 0) {
                ans = (ans + recurse(A-1, B-i)) % mod;
            }
        }
        return ans;
    }

    private static int recurse(int d, int sum) {
        // final case i.e. we are able to create a number with d digits whose sum is equal to the given sum
        if (d == 0 && sum == 0) {
            return 1;
        }
        // if there are no digits left and the sum is still not zero then there is no way to make the sum
        if (d == 0) {
            return 0;
        }
        int ans = 0;
        for (int i=0;i<10;i++) {
            if (sum - i >= 0) {
                ans = (ans + recurse(d-1, sum-i)) % mod;
            }
        }
        return ans;
    }

    static int[][] dp;

    public static int solve1(int A, int B) {
        dp = new int[A+1][B+1];
        for (int i=0;i<A+1;i++) {
            for (int j=0;j<B+1;j++) {
                dp[i][j] = -1;
            }
        }
        long ans = 0;
        for (int i=1;i<10;i++) {
            if (B - i >= 0) {
                ans = ans + recurse1(A-1, B-i);
                ans = ans % mod;
            }
        }
        return (int)ans;
    }

    private static int recurse1(int d, int sum) {
        // final case i.e. we are able to create a number with d digits whose sum is equal to the given sum
        if (d == 0 && sum == 0) {
            return 1;
        }
        // if there are no digits left and the sum is still not zero then there is no way to make the sum
        if (d == 0) {
            return 0;
        }
        if (dp[d][sum] != -1) {
            return dp[d][sum];
        }
        long ans = 0;
        for (int i=0;i<10;i++) {
            if (sum - i >= 0) {
                ans = ans + recurse1(d-1, sum-i);
                ans = ans % mod;
            }
        }
        dp[d][sum] = (int)ans;
        return dp[d][sum];
    }

    /**
     * TC = O(AB)
     * @param A
     * @param B
     * @return
     */
    public int solve2(int A, int B) {
        int mod = 1000000007;
        int[][] dp = new int[A+1][B+1];
        for (int i=0;i<B+1;i++) {
            // a number with only one digit can form a sum from 0-9
            if (i < 10) {
                dp[1][i] = 1;
            }
        }
        for (int i=2;i<A+1;i++) {
            // calculate the count of no.s with i digits whose sum is equal to j
            for (int j=1;j<B+1;j++) {
                for (int k=0;k<10;k++) {
                    if (j-k > 0) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % mod;
                    }
                }
            }
        }
        return dp[A][B];
    }

    public static void main(String[] args) {
        int A = 3, B = 5;
        System.out.println(solve1(A,B));
    }
}

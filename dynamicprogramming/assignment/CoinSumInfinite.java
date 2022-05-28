package dynamicprogramming.assignment;

public class CoinSumInfinite {

    public static int coinchange2(int[] A, int B) {
        return ways(A, B, -1);
    }

    /**
     * When order is not important
     * @param A
     * @param sum
     * @return
     */
    private static int ways(int[] A, int sum, int prev) {
        if (sum == 0) {
            return 1;
        }
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] <= sum && A[i] >= prev) {
                count += ways(A, sum-A[i], A[i]);
            }
        }
        return count;
    }

    /**
     * When order is important
     * @param A
     * @param sum
     * @return
     */
    private static int ways1(int[] A, int sum) {
        if (sum == 0) {
            return 1;
        }
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] <= sum) {
                count += ways1(A, sum-A[i]);
            }
        }
        return count;
    }

    /**
     * TC = O(n*B), SC= O(n*B)
     * @param A
     * @param B
     * @return
     */
    public static int coinchange(int[] A, int B) {
        int mod = 1000007;
        int[][] dp = new int[A.length+1][B+1];
        // no. of ways to make sum 0 with 0 coins
        dp[0][0] = 1;
        for (int i=1;i<A.length+1;i++) {
            dp[i][0]  = 1;
            for (int j=1;j<B+1;j++) {
                dp[i][j] = dp[i-1][j];
                if (A[i-1] <= j) {
                    dp[i][j] = (dp[i][j] % mod + dp[i][j-A[i-1]] % mod) % mod;
                }
            }
        }
        return dp[A.length][B];
    }

    public static int coinchange3(int[] A, int B) {
        int mod = 1000007;
        int[] dp = new int[B+1];
        dp[0] = 1;
        for (int i=0;i<A.length;i++) {
            for (int j=1;j<B+1;j++) {
                if (A[i] <= j) {
                    dp[j] = (dp[j] % mod + dp[j - A[i]] % mod) % mod;
                }
            }
        }
        return dp[B];
    }

    public static int coinChange(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    private static int helper(int[] nums, int pos, int target) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i=pos; i<nums.length; i++) {
            if (nums[i] <= target) {
                count += helper(nums, i, target-nums[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int B = 4;
//        System.out.println(coinchange2(A,B));
//        System.out.println(coinchangeM(A,B));
        System.out.println(coinchange(A,B));
        System.out.println(coinchange3(A,B));
        System.out.println(coinChange(A, B));
    }
}

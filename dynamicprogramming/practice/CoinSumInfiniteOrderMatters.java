package dynamicprogramming.practice;

public class CoinSumInfiniteOrderMatters {

    private static int totalWays(int[] A, int S) {
        // base case, reached a solution
        if (S == 0) {
            return 1;
        }
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] <= S) {
                count += totalWays(A, S-A[i]);
            }
        }
        return count;
    }

    private static int[] dp;

    /**
     * using memoization, TC = O(S * n),
     * SC = O(S)
     */
    private static int totalWaysM(int[] A, int S) {
        dp = new int[S+1];
        return totalWaysMHelper(A, S);
    }

    private static int totalWaysMHelper(int[] A, int S) {
        // base case, reached a solution
        if (S == 0) {
            return 1;
        }
        // this state is not calculated before
        if (dp[S] == 0) {
            for (int i=0;i<A.length;i++) {
                if (A[i] <= S) {
                    dp[S] += totalWaysMHelper(A, S-A[i]);
                }
            }
        }
        return dp[S];
    }

    /**
     * TC = O(S * n), SC = O(S)
     */
    private static int totalWaysDP(int[] A, int S) {
        int[] dp = new int[S+1];
        // base case
        dp[0] = 1;

        for (int i=1;i<=S;i++) {
            for (int j=0;j<A.length;j++) {
                if (A[j] <= i) {
                    dp[i] += dp[i-A[j]];
                }
            }
        }
        return dp[S];
    }

    public static void main(String[] args) {
        int[] A = {1,2,5};
        int S = 5;
        System.out.println(totalWays(A,S));
        System.out.println(totalWaysM(A, S));
        System.out.println(totalWaysDP(A,S));
    }
}

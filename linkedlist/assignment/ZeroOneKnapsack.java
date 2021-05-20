package linkedlist.assignment;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneKnapsack {

    /**
     * TC = O(n*C), SC = O(n*C)
     */
    public static int solve(int[] A, int[] B, int C) {
        int[][] dp = new int[A.length+1][C+1];
        for (int i=1;i<A.length+1;i++) {
            for (int j=1;j<C+1;j++) {
                // if the weight of the current element is less than or equal to the capacity j
                if (B[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], A[i-1] + dp[i-1][j-B[i-1]]);
                }
                // if the weight becomes greater than j then reject the current element
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[A.length][C];
    }

    public int solve1(int[] A, int[] B, int C) {
        return knapsack(0, C, A, B);
    }

    /**
     * TC = O(2^n), SC = O(n)
     */
    private int knapsack(int id, int weight, int[] A, int[] B) {
        if (id == A.length) {
            return 0;
        }
        // weight of the current element is greater than the capacity
        // so reject the element
        if (B[id] > weight) {
            return knapsack(id+1, weight, A, B);
        }
        // weight of the current element is <= capacity, so we have two choices
        // either select or do not select the element and take the maximum among
        // the two
        int select = A[id] + knapsack(id+1, weight - B[id], A, B);
        int reject = knapsack(id+1, weight, A, B);
        return Math.max(select, reject);
    }

    private int[][] dp;

    /**
     * TC = O(n*C), SC = O(n*C + n) = O(n*C)
     */
    public int solve2(int[] A, int[] B, int C) {
        dp = new int[A.length+1][C+1];
        for (int i=0;i<A.length+1;i++) {
            for (int j=0;j<C+1;j++) {
                dp[i][j] = -1;
            }
        }
        return knapsack1(A.length, C, A, B);
    }

    private int knapsack1(int id, int weight, int[] A, int[] B) {
        if (id == 0 || weight == 0) {
            return 0;
        }
        if (dp[id][weight] != -1) {
            return dp[id][weight];
        }
        // weight of the current element is greater than the capacity
        // so reject the element
        if (B[id-1] > weight) {
            dp[id][weight] = knapsack1(id-1, weight, A, B);
        } else {
            // weight of the current element is <= capacity, so we have two choices
            // either select or do not select the element and take the maximum among the two
            int select = A[id-1] + knapsack1(id-1, weight - B[id-1], A, B);
            int reject = knapsack1(id-1, weight, A, B);
            dp[id][weight] = Math.max(select, reject);
        }
        return dp[id][weight];
    }

    /**
     * TC = O(n*C), SC = O(2*C)
     */
    public static int solve3(int[] A, int[] B, int C) {
        int[] prev = new int[C+1];
        int[] curr = new int[C+1];

        for (int i=0;i<A.length;i++) {
            for (int j=1;j<C+1;j++) {
                // if the weight of the current element is less than or equal to the capacity j
                if (B[i] <= j) {
                    curr[j] = Math.max(prev[j], A[i] + prev[j-B[i]]);
                }
                // if the weight becomes greater than j then reject the current element
                else {
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[C];
    }

    private static List<Integer> solve4(int[] A, int[] B, int C) {
        List<Integer> ans = new ArrayList<>();
        int[][] dp = new int[A.length+1][C+1];
        for (int i=1;i<A.length+1;i++) {
            for (int j=1;j<C+1;j++) {
                if (B[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], A[i-1] + dp[i-1][j-B[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int j = C;
        for (int i=A.length; i>=1; i--) {
            if (dp[i][j] != dp[i-1][j]) {
                ans.add(i);
                j = j-B[i-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        int[] B = {1,3,4,5};
        System.out.println(solve3(A,B,7));
        System.out.println(solve4(A,B,7));
    }
}

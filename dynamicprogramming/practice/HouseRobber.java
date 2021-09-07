package dynamicprogramming.practice;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        return robHelper(nums, 0);
    }

    private int robHelper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        // at each house I have two choices either I can rob it or I cannot rob it
        int rob = nums[i] + robHelper(nums, i+2);
        int notRob = robHelper(nums, i+1);
        return Math.max(rob, notRob);
    }

    private int memo[];

    private int rob2(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return robHelper1(nums, 0);
    }

    private int robHelper1(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // at each house I have two choices either I can rob it or I cannot rob it
        int rob = nums[i] + robHelper1(nums, i+2);
        int notRob = robHelper1(nums, i+1);
        memo[i] = Math.max(rob, notRob);
        return memo[i];
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return robHelper2(nums, n-1);
    }

    private int robHelper2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // at each house I have two choices either I can rob it or I cannot rob it
        int rob = nums[i] + robHelper2(nums, i-2);
        int notRob = robHelper2(nums, i-1);
        memo[i] = Math.max(rob, notRob);
        return memo[i];
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxAmt = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            for (int j=0; j<i-1; j++) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
            }
            maxAmt = Math.max(maxAmt, dp[i]);
        }
        return maxAmt;
    }

    /**
     * dp[n] is the answer
     * @param nums
     * @return
     */
    public int rob4(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=2; i<n+1; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }

    public int rob5(int[] nums) {
        int n = nums.length;
        int robPrevPlusOne = 0;
        int robPrev = nums[0];
        for (int i=2; i<n+1; i++) {
            int current = Math.max(nums[i-1] + robPrevPlusOne, robPrev);
            robPrevPlusOne = robPrev;
            robPrev = current;
        }
        return robPrev;
    }
}

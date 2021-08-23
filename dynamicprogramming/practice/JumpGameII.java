package dynamicprogramming.practice;

import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        return minJumpFromPos(nums, 0);
    }

    private int minJumpFromPos(int[] nums, int index) {
        if (index == nums.length-1) {
            return 0;
        }
        int minJump = 1001;
        // to avoid overflow
        int furthestJump = Math.min(index + nums[index], nums.length-1);
        // checking every possible jump size from the current position
        for (int i=index+1; i<=furthestJump; i++) {
            minJump = Math.min(minJump, 1 + minJumpFromPos(nums, i));
        }
        return minJump;
    }

    /**
     * TC = O(n^2)
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;

        for (int i=n-2;i>=0;i--) {
            int furthestJump = Math.min(i + nums[i], n-1);
            for (int j=i+1; j<=furthestJump; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[0];
    }

    /**
     * TC = O(n)
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int farthestJump = 0;
        int minJumps = 0;
        // start from the first index and shift the window
        while (right < n-1) {
            // for each element in the window find the largest jump that you can make
            for (int i=left; i<=right; i++) {
                farthestJump = Math.max(farthestJump, i + nums[i]);
            }
            // after finding the largest jump again shift the window
            left = right + 1;
            right = farthestJump;
            // increment the jump count
            minJumps++;
        }
        return minJumps;
    }
}

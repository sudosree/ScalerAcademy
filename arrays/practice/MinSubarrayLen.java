package arrays.practice;

public class MinSubarrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right-left+1);
                // if the sum >= target contract the window
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}

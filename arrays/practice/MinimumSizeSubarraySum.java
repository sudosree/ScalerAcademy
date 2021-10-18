package arrays.practice;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

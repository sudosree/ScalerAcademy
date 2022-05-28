package slidingwindow.practice;

public class LongestSubarrayWithOnes {

    private static int longestSubarrayWithOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxOnes = 0, maxLen = 0;
        while (right < n) {
            if (nums[right] == 1) {
                maxOnes++;
            }
            // if the no. of remaining zeroes to replace
            // is more than k then shrink the window
            if (right - left + 1 - maxOnes > k) {
                if (nums[left] == 1) {
                    maxOnes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        System.out.println(longestSubarrayWithOnes(nums, k));
    }
}

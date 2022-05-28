package slidingwindow.practice;

public class SmallestSubarraySum {

    private static int smallestSubarraySum(int[] nums, int S) {
        int n = nums.length;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            // once the sum >= S then start shrinking the window
            while (sum >= S) {
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[left];
                left++;
            }
            // if the sum < S then keep expanding the window
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 1, 6};
        int S = 8;
        System.out.println(smallestSubarraySum(nums, S));
    }
}

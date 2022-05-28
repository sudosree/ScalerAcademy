package slidingwindow.practice;

public class FindMaxSumK {

    private static int maxSum(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i=0; i<=n-k; i++) {
            int sum = 0;
            for (int j=i; j<i+k; j++) {
                sum += nums[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int maxSumSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max = 0, sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }
        max = Math.max(max, sum);
        for (int i=1; i<=n-k; i++) {
            sum -= nums[i-1];
            sum += nums[i+k-1];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(nums, k));
        System.out.println(maxSumSlidingWindow(nums, k));
    }
}

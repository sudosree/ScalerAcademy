package slidingwindow.practice;

import java.util.Arrays;

public class FindAverageK {

    private static double[] findAverage(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        for (int i=0; i<=n-k; i++) {
            double sum = 0;
            for (int j=i; j<i+k; j++) {
                sum += nums[j];
            }
            ans[i] = sum/k;
        }
        return ans;
    }

    private static double[] findAverageSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        double sum = 0;
        // find the sum of the first subarray of size k
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }
        ans[0] = sum/k;
        for (int i=1; i<=n-k; i++) {
            sum -= nums[i-1];
            sum += nums[i+k-1];
            ans[i] = sum/k;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,6,-1,4,1,8,2};
        int k = 5;
        System.out.println(Arrays.toString(findAverage(nums, k)));
        System.out.println(Arrays.toString(findAverageSlidingWindow(nums, k)));
    }
}

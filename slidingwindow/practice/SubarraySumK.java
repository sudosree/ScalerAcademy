package slidingwindow.practice;

import java.util.Arrays;

public class SubarraySumK {

  private static int[] findSubArraySum(int k, int[] nums) {
    int n = nums.length;
    int[] res = new int[n-k+1];
    int left = 0, right = 0;
    int sum = 0;
    while (right < n) {
      sum += nums[right];
      if (right >= k-1) {
        res[left] = sum;
        sum -= nums[left];
        left++;
      }
      right++;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7,8};
    int k = 3;
    System.out.println(Arrays.toString(findSubArraySum(k, nums)));
  }

}

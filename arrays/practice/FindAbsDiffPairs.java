package arrays.practice;

import java.util.Arrays;

public class FindAbsDiffPairs {

  private static int findPairs(int[] nums) {
    int n = nums.length;
    int[] abs = new int[n];
    for (int i=0; i<n; i++) {
      abs[i] = Math.abs(nums[i]);
    }
    Arrays.sort(abs);
    int count = 0;
    // for each index i find the maximum j such that abs[j] <= 2 * abs[i]
    for (int i=0; i<n; i++) {

      int left = i+1;
      int right = n-1;
      int maxJ = i;

      while (left <= right) {
        int mid = left + (right - left)/2;
        if (abs[mid] <= 2 * abs[i]) {
          maxJ = mid;
          left = mid+1;
        } else {
          right = mid-1;
        }
      }
      count += maxJ - i;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {-9, 6, -5, 3};
    System.out.println(findPairs(nums));
  }
}

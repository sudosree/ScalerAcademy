package twopointers.practice;

import java.util.Arrays;

public class ThreeSumClosestII {

  private static int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int smallestSum = 0, smallestDiff = Integer.MAX_VALUE;
    for (int i=0; i<nums.length; i++) {
      int left = i+1, right = nums.length-1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        int diff = Math.abs(target - sum);
        // current sum is equal to the target sum
        if (diff == 0) {
          return target;
        } else if (diff < smallestDiff) {
          smallestDiff = diff;
          smallestSum = sum;
        } else if (diff == smallestDiff) {
          smallestSum = Math.min(smallestSum, sum);
        }

        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return smallestSum;
  }

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 2, 6};
    int target = 5;
    System.out.println(threeSumClosest(nums, target));
  }

}

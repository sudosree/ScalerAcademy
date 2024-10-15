package twopointers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmallerII {

  private static List<List<Integer>> threeSumSmaller(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i=0; i<nums.length; i++) {
      twoSumSmaller(nums, target, ans, i);
    }
    return ans;
  }

  private static void twoSumSmaller(int[] nums, int target, List<List<Integer>> ans, int i) {
    int left = i+1, right = nums.length-1;
    while (left < right) {
      int sum = nums[i] + nums[left] + nums[right];
      if (sum < target) {
        int j = right;
        while (j > left) {
          ans.add(Arrays.asList(nums[i], nums[left], nums[j]));
          j--;
        }
        left++;
      } else {
        right--;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {-1, 4, 2, 1, 3};
    int target = 5;
    System.out.println(threeSumSmaller(nums, target));
  }

}

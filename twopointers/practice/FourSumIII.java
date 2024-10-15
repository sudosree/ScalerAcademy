package twopointers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumIII {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }

  private static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    // if we run out of numbers
    if (start == nums.length) {
      return res;
    }
    // k remaining values to add to the sum and the avg of these values
    // is at least k
    long avgVal = target/k;
    // if the smallest value is > target/k or if the largest value is < target/k
    if (nums[start] > avgVal || nums[nums.length-1] < avgVal) {
      return res;
    }
    if (k == 2) {
      return twoSum(nums, target, start);
    }
    for (int i=start; i<nums.length; i++) {
      // to avoid duplicates
      if (i == start || nums[i] != nums[i-1]) {
        List<List<Integer>> curr = kSum(nums, target-nums[i], i+1, k-1);
        for (List<Integer> list : curr) {
          res.add(new ArrayList<>(List.of(nums[i])));
          res.get(res.size()-1).addAll(list);
        }
      }
    }
    return res;
  }

  private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int left = start, right = nums.length-1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        res.add(Arrays.asList(nums[left], nums[right]));
        left++;
        // skip the duplicates
        while (left < right && nums[left] == nums[left-1]) {
          left++;
        }
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
    int target = 294967296;
    System.out.println(fourSum(nums, target));
  }
}

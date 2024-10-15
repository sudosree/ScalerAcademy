package dynamicprogramming.practice;

import java.util.Arrays;
import java.util.List;

public class LengthofLongestSubsequenceSumToTarget {

  private int[][] dp;

  public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    if (nums.isEmpty()) {
      return -1;
    }
    return knapsack(0, nums, target);
  }

  private int knapsack(int i, List<Integer> nums, int sum) {
    // if no elements are left then return 0
    if (i == nums.size()) {
      return 0;
    }
    // if you are able to create a subsequence with sum equal to the given sum
    // then return 0
    if (sum == 0) {
      return 0;
    }
    // every element has two choices - select or reject
    // if the element is less or equal to then select or reject
    // else reject it
    int select = 0;
    if (nums.get(i) <= sum) {
      select = 1 + knapsack(i+1, nums, sum - nums.get(i));
    }
    int reject = knapsack(i+1, nums, sum);
    return Math.max(select, reject);
  }

  public int lengthOfLongestSubsequence1(List<Integer> nums, int target) {
    if (nums.size() == 0) {
      return -1;
    }
    int n = nums.size();
    dp = new int[n+1][target+1];
    for (int i=0; i<n+1; i++) {
      Arrays.fill(dp[i], -1);
    }
    int maxLen = knapsack(0, nums, target);
    return maxLen <= 0 ? -1 : maxLen;
  }

  private int knapsack1(int index, List<Integer> nums, int sum) {
    // you have reached the target sum
    if (sum == 0) {
      return 0;
    }
    // unable to reach the sum or if the index is out of bound
    if (sum < 0 || index == nums.size()) {
      return Integer.MIN_VALUE;
    }
    // you have computed this before
    if (dp[index][sum] != -1) {
      return dp[index][sum];
    }
    int select = 1 + knapsack(index+1, nums, sum - nums.get(index));
    int reject = knapsack(index+1, nums, sum);
    dp[index][sum] = Math.max(select, reject);
    return dp[index][sum];
  }
}

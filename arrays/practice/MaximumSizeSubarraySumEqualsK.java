package arrays.practice;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

  public int maxSubArrayLen(int[] nums, int k) {
    int n = nums.length;
    int maxLen = 0;
    int[] prefixSum = new int[n];
    prefixSum[0] = nums[0];
    for (int i=1; i<n; i++) {
      prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    for (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        if (i == 0) {
          // check if the prefixSum is equal to k
          if (prefixSum[j] == k) {
            maxLen = Math.max(maxLen, j + 1);
          }
        } else {
          // check if there exists a subarray (i,j) in prefixSum whose sum is equal to k
          if (prefixSum[j] - prefixSum[i-1] == k) {
            maxLen = Math.max(maxLen, j - i + 1);
          }
        }
      }
    }
    return maxLen;
  }

  public int maxSubArrayLen1(int[] nums, int k) {
    int n = nums.length;
    int maxLen = 0;
    int prefixSum = 0;
    // keeps track of the prefix sum and its indices
    Map<Integer, Integer> map = new HashMap<>();
    // to handle the case when prefixSum is equal to k
    map.put(0, -1);
    for (int i=0; i<n; i++) {
      prefixSum += nums[i];
      // check if a prefixSum or complement exists such that the difference between the
      // pair of prefixSum numbers is equal to k
      if (map.containsKey(prefixSum - k)) {
        int currLen = i - map.get(prefixSum - k);
        maxLen = Math.max(maxLen, currLen);
      }
      // if the prefixSum is not present in the map then add it to the map along with its index
      if (!map.containsKey(prefixSum)) {
        map.put(prefixSum, i);
      }
    }
    return maxLen;
  }

}

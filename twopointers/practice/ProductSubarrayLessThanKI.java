package twopointers.practice;

import java.util.ArrayList;
import java.util.List;

public class ProductSubarrayLessThanKI {

  public List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int left = 0, n = arr.length;
    int product = 1;
    for (int right=0; right<n; right++) {
      product *= arr[right];
      // shrink the window
      while (product >= target && left < n) {
        product /= arr[left++];
      }
      // create the subarrays
      List<Integer> curr = new ArrayList<>();
      for (int i=right; i>=left; i--) {
        curr.add(0, arr[i]);
        res.add(new ArrayList<>(curr));
      }
    }
    return res;
  }

}

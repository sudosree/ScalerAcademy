package twopointers.practice;

public class ProductSubarrayLessThanK {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    // no subarrays possible
    if (k <= 1) {
      return 0;
    }
    int count = 0;
    int left = 0, right = 0;
    int product = 1;
    while (right < nums.length) {
      product *= nums[right];
      // shrink the window from the left until the product becomes less than k
      while (product >= k) {
        // remove the element at the left pointer from the product
        product /= nums[left++];
      }
      // count the no. of subarrays end at right whose product
      // of all elements is less than k
      count += right - left + 1;
      right++;
    }
    return count;
  }

}

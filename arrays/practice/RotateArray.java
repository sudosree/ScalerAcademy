package arrays.practice;

public class RotateArray {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k%n;
    // reverse the whole array
    reverse(nums, 0, n-1);
    // reverse the first k elements
    reverse(nums, 0, k-1);
    // reverse the remaining n-k elements
    reverse(nums, k, n-1);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
}

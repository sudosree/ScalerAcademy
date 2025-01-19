package arrays.practice;

public class FindPivotIndex {

  public int pivotIndex(int[] nums) {
    int n = nums.length;
    int[] leftSum = new int[n];
    int[] rightSum = new int[n];
    leftSum[0] = 0;
    rightSum[n-1] = 0;
    for (int i=1; i<n; i++) {
      leftSum[i] = leftSum[i-1] + nums[i-1];
    }
    for (int i=n-2; i>=0; i--) {
      rightSum[i] = rightSum[i+1] + nums[i+1];
    }
    for (int i=0; i<n; i++) {
      if (leftSum[i] == rightSum[i]) {
        return i;
      }
    }
    return -1;
  }
}

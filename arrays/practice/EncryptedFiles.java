package arrays.practice;

public class EncryptedFiles {

  private static int encryptedFiles(int n, int k, int[] nums, int[] binary) {
    int initialSum = 0;
    for (int i=0; i<n; i++) {
      // if the file is already decrypted
      if (binary[i] == 1) {
        initialSum += nums[i];
      }
    }
    // keeps track of the sum of all elements in a window that are not decrypted
    int windowSum = 0;
    for (int i=0; i<k ; i++) {
      // if the file is not decrypted
      if (binary[i] == 0) {
        windowSum += nums[i];
      }
    }
    int currSum = windowSum;
    int i = k;
    while (i < n) {
      if (binary[i] == 0) {
        currSum += nums[i];
      }
      if (binary[i-k] == 0) {
        currSum -= nums[i-k];
      }
      windowSum = Math.max(windowSum, currSum);
      i++;
    }
    return initialSum + windowSum;
  }

  public static void main(String[] args) {
    int n = 8, k = 3;
    int[] nums = {6,2,3,7,4,5,8,9};
    int[] binary = {0,1,0,0,0,1,0,0};
    System.out.println(encryptedFiles(n,k,nums,binary));
  }

}

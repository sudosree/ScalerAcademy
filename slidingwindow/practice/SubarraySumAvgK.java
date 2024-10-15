package slidingwindow.practice;

import java.util.Arrays;

public class SubarraySumAvgK {

  private static double[] findAverage(int[] arr, int k) {
    int n = arr.length;
    double[] res = new double[n-k+1];
    int windowStart = 0;
    double sum = 0;
    for (int windowEnd = 0; windowEnd<n; windowEnd++) {
      sum += arr[windowEnd];
      if (windowEnd >= k-1) {
        res[windowStart] = sum/k;
        sum -= arr[windowStart];
        windowStart++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
    int k = 5;
    System.out.println(Arrays.toString(findAverage(arr, k)));
  }

}

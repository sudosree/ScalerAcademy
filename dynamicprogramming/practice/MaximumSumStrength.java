package dynamicprogramming.practice;

public class MaximumSumStrength {

  private static long getMaximumSumOfStrengths(int n, int[] arr) {
    // find the initial strength
    long initialStrength = 0;
    for (int i=0; i<n; i++) {
      initialStrength += (long) arr[i] * (i+1);
    }
    // find the gain at each index i
    long[] gain = new long[n];
    for (int i=0; i<n-1; i++) {
      gain[i] = arr[i] > arr[i+1] ? arr[i] - arr[i+1] : 0;
    }
    // find the max gain from the pos 0
    long maxGain = maxGain(0, n, gain);
    return initialStrength + maxGain;
  }

  private static long getMaximumSumOfStrengthsMemo(int n, int[] arr) {
    // find the initial strength
    long initialStrength = 0;
    for (int i=0; i<n; i++) {
      initialStrength += (long) arr[i] * (i+1);
    }
    // find the gain at each index i
    long[] gain = new long[n];
    for (int i=0; i<n-1; i++) {
      gain[i] = arr[i] > arr[i+1] ? arr[i] - arr[i+1] : 0;
    }
    Long[] memo = new Long[n];
    // find the max gain from the pos 0
    long maxGain = maxGainMemo(0, n, gain, memo);
    return initialStrength + maxGain;
  }

  private static long maxGain(int i, int n, long[] gain) {
    if (i >= n-1) {
      return 0;
    }
    // at each position i, you have two choices either swap arr[i] and arr[i+1] or do not swap
    long gainFromNotSwap = maxGain(i+1, n, gain);
    long gainFromSwap = 0;
    // swap only if there is gain at current position i
    if (gain[i] > 0) {
      gainFromSwap = gain[i] + maxGain(i+2, n, gain);
    }
    return Math.max(gainFromNotSwap, gainFromSwap);
  }

  private static long maxGainMemo(int i, int n, long[] gain, Long[] memo) {
    if (i >= n-1) {
      return 0;
    }
    if (memo[i] != null) {
      return memo[i];
    }
    // at each position i, you have two choices either swap arr[i] and arr[i+1] or do not swap
    long gainFromNotSwap = maxGainMemo(i+1, n, gain, memo);
    long gainFromSwap = 0;
    // swap only if there is gain at current position i
    if (gain[i] > 0) {
      gainFromSwap = gain[i] + maxGainMemo(i+2, n, gain, memo);
    }
    memo[i] = Math.max(gainFromNotSwap, gainFromSwap);
    return memo[i];
  }

  private static long getMaximumSumOfStrengths2(int n, int[] arr) {
    // find the initial strength
    long initialStrength = 0;
    for (int i=0; i<n; i++) {
      initialStrength += (long) arr[i] * (i+1);
    }
    // find the gain at each index i
    long[] gain = new long[n];
    for (int i=0; i<n-1; i++) {
      gain[i] = (arr[i] > arr[i+1]) ? arr[i] - arr[i+1] : 0;
    }

    long[] dp = new long[n+1];
    // base case
    dp[n-1] = 0;
    dp[n] = 0;

    for (int i=n-2; i>=0; i--) {
      // swap arr[i] and arr[i+1]
      if (gain[i] > 0) {
        dp[i] = gain[i] + dp[i+2];
      }
      // do not swap
      dp[i] = Math.max(dp[i], dp[i+1]);
    }

    return initialStrength + dp[0];
  }

  public static void main(String[] args) {
    int n = 4;
    int[] arr = {2,1,4,3};
    System.out.println(getMaximumSumOfStrengths(n, arr));
    System.out.println(getMaximumSumOfStrengthsMemo(n, arr));
    System.out.println(getMaximumSumOfStrengths2(n, arr));
  }
}

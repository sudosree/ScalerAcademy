package dynamicprogramming.assignment;

import java.util.Scanner;

public class FibonacciNumbers {

    private static int[] dp;

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        for (int i=0;i<n+1;i++) {
            dp[i] = -1;
        }
        System.out.println(fib1(n));
    }

    /**
     * Using memoization
     * TC = O(n), SC = O(n) + O(h) = O(n) + O(n) = O(n)
     * @param n
     * @return
     */
    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] >= 0) {
            return dp[n];
        }
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }

    /**
     * other way of memoization
     * @param n
     * @return
     */
    private static int fib1(int n) {
        if (n < 2) {
            dp[n] = n;
        }
        if (dp[n] >= 0) {
            return dp[n];
        }
        dp[n] = fib1(n-1) + fib1(n-2);
        return dp[n];
    }

    /**
     * bottom up approach
     * TC = O(n), SC = O(n)
     */
    private static int fib2(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * bottom up approach
     * TC = O(n), SC = O(1)
     */
    private static int fib3(int n) {
        int first = 0, second = 1;
        int ans = 1;
        for (int i=2;i<=n;i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
    }
}

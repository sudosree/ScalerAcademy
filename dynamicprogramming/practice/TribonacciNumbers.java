package dynamicprogramming.practice;

import java.util.Arrays;

public class TribonacciNumbers {

    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
    }

    public int tribonacci1(int n) {
        int[] trib = new int[n+1];
        Arrays.fill(trib, -1);
        return tribonacciHelper(trib, n);
    }

    private int tribonacciHelper(int[] trib, int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (trib[n] != -1) {
            return trib[n];
        }
        trib[n] = tribonacciHelper(trib, n-3) + tribonacciHelper(trib, n-2) + tribonacciHelper(trib, n-1);
        return trib[n];
    }

    public int tribonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] trib = new int[n+1];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;
        for (int i=3; i<n+1; i++) {
            trib[i] = trib[i-3] + trib[i-2] + trib[i-1];
        }
        return trib[n];
    }

    public int tribonacci3(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int prev1 = 1, prev2 = 1, prev3 = 0;
        for (int i=3; i<n+1; i++) {
            int curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

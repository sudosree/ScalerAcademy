package contest;

import java.util.*;

public class MaximumMinimumMagic
{
    public static int[] solve(int[] A) {
        Arrays.sort(A);
        int n = A.length, mod = 1000000007;
        int max = 0, min = 0;
        for (int i=0;i<n/2;i++) {
            max = (max % mod + (Math.abs(A[i] - A[n - i - 1])) % mod) % mod;
        }
        for (int i=0;i<n-1;i+=2) {
            min = (min % mod + (Math.abs(A[i] - A[i+1])) % mod) % mod;
        }
        return new int[]{max, min};
    }

    public static void main(String[] args)
    {
        int[] A = {3,11,-1,5};
        System.out.println(Arrays.toString(solve(A)));
    }
}

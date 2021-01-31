package contest;

import java.util.*;

public class PairSumDivisibleByM
{
    private static int solve(int[] A, int B) {
        int mod = 1000000007;
        for (int i=0;i<A.length;i++) {
            A[i] = A[i]%B;
        }
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (A[i] == 0) {
                if (freq.containsKey(A[i])) {
                    count = (count + freq.get(A[i])) % mod;
                }
            } else if (freq.containsKey(B - A[i])) {
                count = (count + freq.get(B - A[i])) % mod;
            }
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return count % mod;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5};
        int B = 2;
        System.out.println(solve(A,B));
    }
}

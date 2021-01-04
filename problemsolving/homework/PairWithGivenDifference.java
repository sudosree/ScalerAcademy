package problemsolving.homework;

import java.util.*;

public class PairWithGivenDifference
{

    /**
     * TC = O(n), SC = O(n)
     */
    private static int solve(int[] A, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        int count = 0;
        for (int num : freq.keySet()) {
            // if the sum is zero there has to be duplicate elements
            if (B == 0) {
                if (freq.get(num) > 1) {
                    count++;
                }
            } else if (freq.containsKey(num-B)) {
                count++;
            }
        }
        return count;
    }

    /**
     * TC = O(n^2), SC = O(n)
     */
    private static int solve1(int[] A, int B) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int i=0;i<A.length-1;i++) {
            for (int j=i+1;j<A.length;j++) {
                if (Math.abs(A[i] - A[j]) == B) {
                    // to handle the unique pair
                    pairMap.put(Math.min(A[i],A[j]), Math.max(A[i],A[j]));
                }
            }
        }
        return pairMap.size();
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2};
        int B = 0;
        System.out.println(solve(A,B));
    }
}

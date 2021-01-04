package problemsolving.assignment;

import java.util.*;

public class CheckConsecutiveElements
{

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve(int[] A) {
        // find the min and second min element
        long min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] < min) {
                secondMin = min;
                min = A[i];
            } else if (A[i] < secondMin) {
                secondMin = A[i];
            }
        }
        long d = secondMin - min;

        // find the sum of AP because if the array were sorted and all the elements
        // are consecutive then it would form an AP series, assume that all the elements in A are
        // consecutive, so it would form an AP series
        long apSum = (A.length * (2 * min + (A.length-1) * d))/2;

        // find the actual sum of all the elements in the array
        long sum = 0;
        for (int i=0;i<A.length;i++) {
            sum += A[i];
        }
        return apSum == sum ? 1 : 0;
    }

    /**
     * This will not work for duplicate elements
     * TC = O(n), SC = O(1)
     */
    private static int solve1(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }
        for (int i=0;i<A.length;i++) {
            int index = A[i] - min;
            if (index >= 0 && index < A.length) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    /**
     * This will work for duplicate elements
     * TC = O(n), SC = O(n)
     */
    private static int solve2(int[] A) {
        // frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }
        for (int i=0;i<A.length;i++) {
            int index = A[i] - min;
            // check if indexes are in the range and also the frequency of the elements
            if (index >= 0 && index < A.length && map.get(A[i]) == 1) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        int[] A = {4,5,2,3,6,8};
        System.out.println(solve1(A));
    }
}

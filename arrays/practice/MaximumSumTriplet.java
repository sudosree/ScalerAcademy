package arrays.practice;

import java.util.*;

public class MaximumSumTriplet
{

    /**
     * TC = O(n^2)
     */
    public static int solve(int[] A) {
        int max = 0;
        for (int j=0;j<A.length;j++) {
            // find max value on the left side smaller than A[j]
            int max_left = -1;
            for (int i=0;i<j;i++) {
                if (max_left < A[i] && A[i] < A[j]) {
                    max_left = A[i];
                }
            }
            // find max value on the right side greater than A[j]
            int max_right = -1;
            for (int i=j+1;i<A.length;i++) {
                if (max_right < A[i] && A[i] > A[j]) {
                    max_right = A[i];
                }
            }
            // if there exists triplets
            if (max_left != -1 && max_right != -1) {
                max = Math.max(max, max_left + A[j] + max_right);
            }
        }
        return max;
    }

    /**
     * TC = O(nlogn), SC = O(n)
     */
    public static int solve1(int[] A) {
        int max_sum = Integer.MIN_VALUE;
        int n = A.length;
        // maximum suffix array
        int[] suffix_max = new int[n];
        suffix_max[n-1] = A[n-1];
        for (int i=n-2;i>=0;i--) {
            suffix_max[i] = Math.max(suffix_max[i+1], A[i]);
        }
        TreeSet<Integer> sorted_set = new TreeSet<Integer>();
        for (int j=1;j<n-1;j++) {
            // find the max on the right side greater than A[j] using suffix array
            int right = suffix_max[j+1];
            sorted_set.add(A[j-1]);
            // find the max on the left side lesser than A[j] using binary search
            Integer left = sorted_set.lower(A[j]);
            if (left != null && A[j] < right) {
                max_sum = Math.max(max_sum, left + A[j] + right);
            }
        }
        return max_sum;
    }
}

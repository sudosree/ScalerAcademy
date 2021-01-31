package problemsolving.homework;

import java.util.*;

/**
 * Problem Description
 *
 * You are given an array A having N integers.
 *
 * You have to divide / split the array into 2 subsequence partitions such that:
 *
 * Both the partitions are non-empty.
 * Each integer A[i] in the array belongs to exactly one of the two partitions.
 * Absolute difference between the maximum of first partition and the minimum of second partition is minimum possible.
 *
 * If B and C represent the two partitions, then size(B) >= 1, size(C) >= 1 and |max(B) - min(C)| is minimum possible. You have to find such a spliting and tell the minimum value of |max(B) - max(C)|.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return a single integer denoting the absolute difference.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 1, 2, 6, 4]
 *
 * Input 2:
 *
 *  A = [2, 1, 3, 2, 4, 3]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 *
 * Output 2:
 *
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  B = [1, 2, 4]
 *  C = [3, 6]
 *  max(B) = 4, min(C) = 3
 *  abs(max(B) - min(C)) = abs(4 - 3) = abs(1) = 1
 *
 * Explanation 2:
 *
 *  B = [2, 1]
 *  C = [3, 2, 4, 3]
 *  max(B) = 2, min(C) = 2
 *  abs(max(B) - min(C)) = abs(2 - 2) = abs(0) = 0
 */
public class OptimalPartitioning
{
    private static int solve(int[] A) {
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        for (int i=0;i<A.length-1;i++) {
            int max = A[i];
            int min = A[i+1];
            diff = Math.min(diff, Math.abs(max-min));
        }
        return diff;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 1, 3, 2, 4, 3};
        System.out.println(solve(A));
    }
}

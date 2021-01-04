package sorting.homework;

import java.util.*;

/**
 * Problem Description
 *
 * You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.
 *
 * Find the minimum number of steps.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 *
 * The only argument given is an Array A, having N integers.
 *
 *
 * Output Format
 *
 * Return the Minimum number of steps required to make all elements unique.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 1, 3]
 *
 * Input 2:
 *
 *  A = [2, 4, 5]
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
 *  We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
 *
 * Explanation 2:
 *
 *  All elements are distinct.
 */
public class UniqueElements
{
    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int solve(int[] A) {
        int[] freq = new int[100000];
        for (int i=0;i<A.length;i++) {
            freq[A[i]]++;
        }
        int count = 0;
        for (int i=0;i<freq.length;i++) {
            // check if element is not unique
            if (freq[i] > 1) {
                int extra = freq[i] - 1;
                count += extra;
                freq[i] -= extra;
                freq[i+1] += extra;
            }
        }
        return count;
    }

    /**
     * Time Complexity - O(nlogn) + O(n) = O(nlogn)
     * Space Complexity - O(1)
     */
    private static int solve1(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i=1;i<A.length;i++) {
            // check if the elements are not unique
            if (A[i] == A[i-1]) {
                count++;
                A[i]++;
            }
            // if the current element is less than its previous
            else if (A[i-1] > A[i]) {
                int times = (A[i-1] + 1) - A[i];
                A[i] += times;
                count += times;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {2,3,4,5,4,3,4};
        System.out.println(solve1(A));
    }
}

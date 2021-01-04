package sorting.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array of integers A, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 106
 * 1 <= A[i] <= 106
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an array arranged in the sequence as described.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 *
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [2, 1, 4, 3]
 *
 * Output 2:
 *
 * [2, 1]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 *
 * Explanation 1:
 *
 * Only possible answer is [2, 1].
 */
public class WaveArray
{

    /**
     * Time Complexity - O(nlogn) + O(n) = O(nlogn)
     * Space Complexity - O(1)
     */
    private static int[] solve(int[] A) {
        Arrays.sort(A);
        for (int i=0;i<A.length;i+=2) {
            if (i+1 < A.length) {
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {5, 1, 3, 2, 4};
        int[] ans = solve(A);
        for (int i=0;i<ans.length;i++) {
            System.out.println(ans[i]);
        }
    }
}

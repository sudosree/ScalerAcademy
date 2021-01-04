package sorting.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
 *
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
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
 * First and only argument is an integer array A of size N.
 *
 *
 * Output Format
 *
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 5, 1]
 *
 * Input 2:
 *
 *  A = [2, 4, 1]
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
 *  We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 *
 * Explanation 2:
 *
 *  There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgression
{

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int solve(int[] A) {
        // find the min and second-min
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        // hashmap for O(1) lookup time
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (A[i] < min) {
                secondMin = min;
                min = A[i];
            } else if (A[i] < secondMin) {
                secondMin = A[i];
            }
            map.put(A[i],i);
        }
        int d = secondMin - min;
        int j = 1;
        while (j < A.length-1) {
            if (!map.containsKey(secondMin + j*d)) {
                return 0;
            }
            j++;
        }
        return 1;
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static int solve1(int[] A) {
        Arrays.sort(A);
        int d = A[1] - A[0];
        for (int i=1;i<A.length;i++) {
            if (A[i] - A[i-1] != d) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        int[] A = {11,3,5,1,7,9};
        System.out.println(solve(A));
    }
}

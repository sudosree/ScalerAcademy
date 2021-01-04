package sorting.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given an integer array A of size N. In one operation, you can remove any element from the array, and the cost of this operation is the sum of all elements in the array present before this operation.
 *
 * Find the minimum cost to remove all elements from the array.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= N <= 1000
 * 1 <= A[i] <= 103
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the total cost of removing all elements from the array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [2, 1]
 *
 * Input 2:
 *
 *  A = [5]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 *
 * Output 2:
 *
 *  5
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Given array A = [2, 1]
 *  Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 *  Remove 1 from the array => []. Cost of this operation is (1) = 1.
 *  So, total cost is = 3 + 1 = 4.
 *
 *
 * Explanation 2:
 *
 *  There is only one element in the array. So, cost of removing is 5.
 */
public class ElementsRemoval
{

    /**
     * Time Complexity - O(nlogn) + O(n^2) = O(n^2)
     * Space Complexity - O(1)
     */
    private static int solve(int[] A) {
        int cost = 0;
        Arrays.sort(A);
        for (int i=A.length-1;i>=0;i--) {
            for (int j=i;j>=0;j--) {
                cost += A[j];
            }
        }
        return cost;
    }

    /**
     * Time Complexity - O(nlogn) + O(n) = O(nlogn)
     * Space Complexity - O(1)
     */
    private static int solve1(int[] A) {
        int cost = 0;
        Arrays.sort(A);
        // how many times a number is contributing to the cost
        for (int i=0;i<A.length;i++) {
            cost += (A.length - i) * A[i];
        }
        return cost;
    }

    public static void main(String[] args)
    {
        int[] A = {3,1,4,2};
        System.out.println(solve1(A));
    }
}

package sorting.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Find the Bth smallest element in given array A .
 *
 * NOTE: Users should try to solve it in <= B swaps.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 *
 * 1 <= B <= min(|A|, 500)
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is vector A.
 *
 * Second argument is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the Bth smallest element in given array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [2, 1, 4, 3, 2]
 * B = 3
 *
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 *
 * Output 2:
 *
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  3rd element after sorting is 2.
 *
 * Explanation 2:
 *
 *  2nd element after sorting is 2.
 */
public class KthSmallestElement
{

    /**
     * Time Complexity - O(Bn)
     * Space Complexity - O(1)
     */
    private static int kthSmallest(int[] A, int B) {
        for (int i=0;i<B;i++) {
            int smallest = A[i], smallestIndex = i;
            for (int j=i+1;j<A.length;j++) {
                if (A[j] < smallest) {
                    smallest = A[j];
                    smallestIndex = j;
                }
            }
            // swap the smallest element with the first element
            if (smallestIndex != i) {
                int temp = A[i];
                A[i] = smallest;
                A[smallestIndex] = temp;
            }
        }
        return A[B-1];
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static int solve(int[] A, int B) {
        Arrays.sort(A);
        return A[B-1];
    }

    public static void main(String[] args)
    {
        int[] A = {1,2};
        int B = 2;
        System.out.println(kthSmallest(A,B));
    }
}

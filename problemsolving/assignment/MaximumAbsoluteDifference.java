package problemsolving.assignment;

/**
 * Problem Description
 *
 * You are given an array of N integers, A1, A2, .... AN.
 *
 * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of f(i, j).
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3, -1]
 *
 * Input 2:
 *
 *
 * A = [2]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 5
 *
 * Output 2:
 *
 * 0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 *
 * Explanation 2:
 *
 * Only possibility is i = 1 and j = 1. That gives answer = 0.
 */
public class MaximumAbsoluteDifference
{
    /**
     * TC = O(n), SC = O(1)
     */
    private static int maxArr(int[] A) {
        int first_max = Integer.MIN_VALUE, first_min = Integer.MAX_VALUE;
        int second_max = Integer.MIN_VALUE, second_min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            int sum = A[i] + i;
            int diff = A[i] - i;
            first_max = Math.max(first_max, sum);
            first_min = Math.min(first_min, sum);
            second_max = Math.max(second_max, diff);
            second_min = Math.min(second_min, diff);
        }
        int diff1 = first_max - first_min;
        int diff2 = second_max - second_min;
        return Math.max(diff1, diff2);
    }

    public int maxArr1(int[] A) {
        int n = A.length;
        int first_max = Integer.MIN_VALUE, first_min = Integer.MAX_VALUE;
        int second_max = Integer.MIN_VALUE, second_min = Integer.MAX_VALUE;
        int max_diff = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            int sum = A[i] + i;
            first_max = Math.max(first_max, sum);
            first_min = Math.min(first_min, sum);
            int diff = A[i] - i;
            second_max = Math.max(second_max, diff);
            second_min = Math.min(second_min, diff);
        }
        max_diff = Math.max(max_diff, first_max - first_min);
        max_diff = Math.max(max_diff, second_max - second_min);
        return max_diff;
    }

    public static void main(String[] args)
    {
        int[] A = {7,1,2,3,4,0,2,6};
        System.out.println(maxArr(A));
    }
}

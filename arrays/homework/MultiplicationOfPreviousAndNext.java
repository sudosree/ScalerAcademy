package arrays.homework;

/**
 * Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions. a) First element is replaced by multiplication of first and second. b) Last element is replaced by multiplication of last and second last.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 * Output Format
 *
 * Return the updated array.
 *
 * Constraints
 *
 * 1 <= length of the array <= 100000
 * -10^4 <= A[i] <= 10^4
 *
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [2, 3, 8, 15, 20]
 *
 * Input 2:
 *     A = [5, 17, 100, 11]
 * Output 2:
 *     [85, 500, 187, 1100]
 *
 * ×
 * -->
 */
public class MultiplicationOfPreviousAndNext
{
    private static int[] solve(int[] A) {
        if (A.length == 1) {
            return A;
        }
        int[] ans = new int[A.length];
        for (int i=0;i<A.length;i++) {
            if (i == 0) {
                ans[i] = A[i] * A[i+1];
            } else if (i == A.length-1) {
                ans[i] = A[i] * A[i-1];
            } else {
                ans[i] = A[i-1] * A[i+1];
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {5, 17, 100, 11};
        int[] res = solve(A);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}

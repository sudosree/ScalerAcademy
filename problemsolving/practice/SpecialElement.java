package problemsolving.practice;

/**
 * Problem Description
 *
 * Given an integer array A of size N. You need to count the number of special elements in the given array.
 *
 * A element is special if removal of that element make the array balanced.
 *
 * Array will be balanced if sum of even index element equal to sum of odd index element.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
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
 * Return an integer denoting the count of special elements.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [2, 1, 6, 4]
 *
 * Input 2:
 *
 *  A = [5, 5, 2, 5, 8]
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
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  After deleting 1 from array : {2,6,4}
 *     (2+4) = (6)
 *  Hence 1 is the only special element, so count is 1
 *
 * Explanation 2:
 *
 *  If we delete A[0] or A[1] , array will be balanced
 *     (5+5) = (2+8)
 *  So A[0] and A[1] are special elements, so count is 2.
 */
public class SpecialElement
{

    /**
     * TC = O(n), SC = O(n)
     */
    private static int solve(int[] A) {
        int[] even_prefix_sum = new int[A.length];
        int[] odd_prefix_sum = new int[A.length];
        int even_sum = 0, odd_sum = 0;
        for (int i=0;i<A.length;i++) {
            if (i%2 == 0) {
                even_sum += A[i];
            } else {
                odd_sum += A[i];
            }
            even_prefix_sum[i] = even_sum;
            odd_prefix_sum[i] = odd_sum;
        }
        int left_even_sum = 0, left_odd_sum = 0, right_even_sum, right_odd_sum;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            //even sum = left even sum + right odd sum
            //odd sum = left odd sum + right even sum
            if (i > 0) {
                left_even_sum = even_prefix_sum[i-1];
                left_odd_sum = odd_prefix_sum[i-1];
            }
            right_even_sum = even_prefix_sum[A.length-1] - even_prefix_sum[i];
            right_odd_sum = odd_prefix_sum[A.length-1] - odd_prefix_sum[i];
            int evenSum = left_even_sum + right_odd_sum;
            int oddSum = left_odd_sum + right_even_sum;
            if (evenSum == oddSum) {
                count++;
            }
        }
        return count;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve1(int[] A) {
        int even_sum = 0, odd_sum = 0;
        for (int i=0;i<A.length;i++) {
            if (i%2 == 0) {
                even_sum += A[i];
            } else {
                odd_sum += A[i];
            }
        }
        int count = 0;
        int left_even_sum = 0, left_odd_sum = 0, right_even_sum = even_sum, right_odd_sum = odd_sum;
        for (int i=0;i<A.length;i++) {
            //even sum = left even sum + right odd sum
            //odd sum = left odd sum + right even sum
            if (i%2 == 0) {
                right_even_sum -= A[i];
                if (left_even_sum + right_odd_sum == left_odd_sum + right_even_sum) {
                    count++;
                }
                left_even_sum += A[i];
            } else {
                right_odd_sum -= A[i];
                if (left_even_sum + right_odd_sum == left_odd_sum + right_even_sum) {
                    count++;
                }
                left_odd_sum += A[i];
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {5, 5, 2, 5, 8};
        System.out.println(solve(A));
    }
}

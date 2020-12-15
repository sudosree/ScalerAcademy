package BitManipulation.homework;

/**
 * Problem Description
 *
 * Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 *
 *
 * Problem Constraints
 *
 *     2 <= A <= 5*106
 *
 *     0 <= A <= INTMAX
 *
 *
 *
 * Input Format
 *
 * First and only argument of input contains an integer array A.
 *
 *
 * Output Format
 *
 * Return a single integer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 *
 * Input 2:
 *
 *  A = [0, 0, 0, 1]
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
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  4 occurs exactly once in Input 1.
 *  1 occurs exactly once in Input 2.
 */
public class SingleNumberII
{
    private static int solve(int[] A) {
        int ans = 0;
        for (int j=0;j<32;j++) {
            int count = 0;
            // count the no. of set bits at each bit position for every number A[i]
            for (int i=0;i<A.length;i++) {
                if (((A[i] >> j) & 1) == 1) {
                    count++;
                }
            }
            ans += (count%3 == 1) ? Math.pow(2, j) : 0;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {2,4,2,2,3,3,3,4,4,6,7,7,7,5,5,5};
        System.out.println(solve(A));
    }
}

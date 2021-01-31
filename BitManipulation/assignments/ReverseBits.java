package BitManipulation.assignments;

/**
 * Problem Description
 *
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 * Problem Constraints
 *
 * 0 <= A <= 232
 *
 *
 * Input Format
 *
 * First and only argument of input contains an integer A.
 *
 *
 * Output Format
 *
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  0
 *
 * Input 2:
 *
 *  3
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  0
 *
 * Output 2:
 *
 *  3221225472
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 *
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */
public class ReverseBits
{
    private static long solve(int A) {
        long ans = 0;
        for (int i=0;i<32;i++) {
            if (((A >> i) & 1) == 1) {
                ans += Math.pow(2, 32-i-1);
            }
        }
        return ans;
    }

    private static long solve1(int A) {
        long ans = 0;
        for (int i=0;i<32;i++) {
            if (((A >> i) & 1) == 1) {
                ans |= 1L << (31 - i);
            }
        }
        return ans;
    }

    private static long solve2(int A) {
        long ans = 0;
        int i = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                ans |= 1L << (31 - i);
            }
            A >>= 1;
            i++;
        }
        return ans;
    }

    private static long solve3(long a) {
        long ans = a;
        for (int i=0;i<16;i++) {
            // check if ith and (32 - i - 1)th bit are different or not
            // if different then swap the bits
            long ith_bit = (a >> i) & 1;
            long jth_bit = (a >> (31 - i)) & 1;
            // if both the bits are different
            if ((ith_bit ^ jth_bit) == 1) {
                // then swap the bits
                ans ^= (1L << i) | (1L << (31 - i));
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int A = 3;
        System.out.println(solve3(A));
    }
}

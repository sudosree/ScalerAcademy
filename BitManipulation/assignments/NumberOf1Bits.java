package BitManipulation.assignments;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 *
 * Example:
 *
 * The 32-bit integer 11 has binary representation
 *
 * 00000000000000000000000000001011
 *
 * so the function should return 3.
 */
public class NumberOf1Bits
{
    private static int solve(long a) {
        int count = 0;
        for (int i=0;i<32;i++) {
            if (((a >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    private static int solve1(long a) {
        int count = 0;
        for (int i=0;i<32;i++) {
            if ((a & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        long A = 11;
        System.out.println(solve1(A));
    }
}

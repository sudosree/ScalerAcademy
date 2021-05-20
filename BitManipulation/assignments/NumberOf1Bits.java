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

    /**
     * TC = O(32)
     */
    private static int solve(long a) {
        int count = 0;
        for (int i=0;i<32;i++) {
            if (((a >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * TC = O(32)
     */
    private static int solve1(long a) {
        int count = 0;
        for (int i=0;i<32;i++) {
            if ((a & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * TC = O(no. of set bits)
     */
    private static int solve2(long a) {
        int count = 0;
        while (a > 0) {
            count++;
            a = a & (a-1);
        }
        return count;
    }

    /**
     * TC = O(no. of bits)
     */
    private static int solve3(long a) {
        int count = 0;
        while (a > 0) {
            if ((a & 1) == 1) {
                count++;
            }
            a >>= 1;
        }
        return count;
    }

    public static void main(String[] args)
    {
        long A = 11;
        System.out.println(solve2(A));
    }
}

package BitManipulation.homework;

/**
 * Problem Description
 *
 * Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
 *
 * Return the count modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 109
 *
 *
 * Input Format
 *
 * First and only argument is an integer A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *
 * Input 2:
 *
 *  A = 1
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
 *  DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *     2          10        1
 *     3          11        2
 *  1 + 1 + 2 = 4
 *  Answer = 4 % 1000000007 = 4
 *
 * Explanation 2:
 *
 *  A = 1
 *   DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *  Answer = 1 % 1000000007 = 1
 */
public class CountTotalSetBits
{
    private static int countSetBits(int N) {
        int count = 0;
        while (N > 0) {
            N = N & (N - 1);
            count++;
        }
        return count;
    }

    private static int solve(int A) {
        int totalSetBits = 0;
        for (int i=1;i<=A;i++) {
            totalSetBits += countSetBits(i);
        }
        return totalSetBits % 1000000007;
    }

    private static int solve1(int A) {
        A = A+1;
        int setBitsSoFar = A/2;
        int powerOf2 = 1 << 1;
        while (powerOf2 <= A) {
            // to get the no. of pairs of 0s and 1s in the current bit position
            // for all the numbers
            int noOfGroups = A/powerOf2;
            int noOfSetBitGroups = noOfGroups/2;
            int noOfSetBits = noOfSetBitGroups * powerOf2;
            setBitsSoFar += noOfSetBits;
            setBitsSoFar += ((noOfGroups & 1) == 1) ? A%powerOf2 : 0;
            powerOf2 <<= 1;
        }
        return setBitsSoFar;
    }

    public static void main(String[] args)
    {
        int A = 5;
        System.out.println(solve1(A));
    }
}

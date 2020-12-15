package arrays.homework;

/**
 * Problem Description
 *
 * "Primal Power" of an array is defined as the count of prime numbers present in it.
 *
 * Given an array of integers A of length N, you have to calculate its Primal Power.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 103
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return the Primal Power of array A.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [-6, 10, 12]
 *
 * Input 2:
 *
 *  A = [-11, 7, 8, 9, 10, 11]
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
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  -6 is not a prime number, as prime numbers are always natural numbers(by definition).
 *   Also, both 10 and 12 are composite numbers.
 *
 * Explanation 2:
 *
 *  7 and 11 are prime numbers. Hence, Primal Power = 2.
 */
public class PrimalPower
{
    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int count = 2;
        for (int i=2;i<=Math.sqrt(n);i++) {
            if (n%i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    private static boolean isPrime1(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int count = 2;
        for (int i=2;i*i<=n;i++) {
            if (n%i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    private static int solve(int[] A) {
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] > 0 && isPrime1(A[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {-11, 7, 8, 9, 10, 11, 5, 13};
        System.out.println(solve(A));
    }
}

package problemsolving.assignment;

/**
 * Problem Description
 *
 * Given an array of integers A of size N.
 *
 * Value of a subarray is defined as BITWISE OR of all elements in it.
 *
 * Return the sum of Value of all subarrays of A % 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 108
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 *
 * Output Format
 *
 * Return the sum of Value of all subarrays of A % 109 + 7.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *
 * Input 2:
 *
 *  A = [7, 8, 9, 10]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  71
 *
 * Output 2:
 *
 *  110
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Value([1]) = 1
 *  Value([1, 2]) = 3
 *  Value([1, 2, 3]) = 3
 *  Value([1, 2, 3, 4]) = 7
 *  Value([1, 2, 3, 4, 5]) = 7
 *  Value([2]) = 2
 *  Value([2, 3]) = 3
 *  Value([2, 3, 4]) = 7
 *  Value([2, 3, 4, 5]) = 7
 *  Value([3]) = 3
 *  Value([3, 4]) = 7
 *  Value([3, 4, 5]) = 7
 *  Value([4]) = 4
 *  Value([4, 5]) = 5
 *  Value([5]) = 5
 *  Sum of all these values = 71
 *
 * Explanation 2:
 *
 *  Sum of value of all subarray is 110.
 */
public class SubarrayOR
{

    /**
     * TC = O(nlogMax) where Max = max element in the array
     */
    public static int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        long n = A.length;
        int mod = 1000000007;
        for (int i=0;i<n;i++) {
            max = Math.max(max, A[i]);
        }
        long powerOf2 = 1;
        int j=0;
        long total_subarrays = ((n * (n+1)) % mod)/2;
        long sum = 0;
        while (powerOf2 <= max) {
            int i=0;
            long subarrays = total_subarrays;
            while (i < n) {
                // ignoring all the 1s
                while (i < n && ((A[i] >> j) & 1) == 1) {
                    i++;
                }
                if (i == n) {
                    continue;
                }
                int s = i;
                // count the consecutive 0s
                while (i < n && ((A[i] >> j) & 1) == 0) {
                    i++;
                }
                // count of consecutive 0s
                long k = i - s;
                long zeroes_subarrays = ((k * (k + 1)) % mod)/2;
                // no. of subarrays which has jth bit set
                subarrays = (subarrays - zeroes_subarrays + mod) % mod;
            }
            sum = (sum % mod + (subarrays % mod * (powerOf2 % mod)) % mod) % mod;
            j++;
            powerOf2 = (powerOf2 << 1) % mod;
        }
        return (int)sum % mod;
    }

    public static void main(String[] args)
    {
        int[] A = {7, 8, 9, 10};
        System.out.println(solve(A));
    }
}

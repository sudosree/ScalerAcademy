package arrays.assignments;

/**
 * Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.
 *
 * A subsequence is said to odd-even in the following cases:
 *
 *     The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
 *
 *     The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
 *
 * Return the maximum possible length of odd-even subsequence.
 *
 * Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 * Output Format
 *
 * Return the maximum possible length of odd-even subsequence.
 *
 * Constraints
 *
 * 1 <= N <= 100000
 * 1 <= A[i] <= 10^9
 *
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 2, 5, 6]
 * Output 1:
 *     4
 *     Explanation 1:
 *         Maximum length odd even subsequence is [1, 2, 5, 6]
 *
 * Input 2:
 *     A = [2, 2, 2, 2, 2, 2]
 * Output 2:
 *     1
 *     Explanation 2:
 *         Maximum length odd even subsequence is [2]
 */
public class OddEvenSubsequence
{
    private static int solve(int[] A) {
        int count = 0;
        int seen = -1;  //initially no value is seen
        for (int i=0;i<A.length;i++) {
            int oddOrEven = A[i]%2; // for odd it will be 1, for even it will be 0
            if (oddOrEven != seen) {
                count++;
                seen = oddOrEven;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {2,4,1,5,6,7};
        System.out.println(solve(A));
    }
}

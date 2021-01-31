package problemsolving.assignment;

/**
 * Problem Description
 *
 * Given an integer array A of size N.
 *
 * You can pick B elements from either left or right end of the array A to get maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4 and array A contains 10 elements then:
 *
 * You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= B <= N
 *
 * -103 <= A[i] <= 103
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum possible sum of elements you picked.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 *
 * Input 2:
 *
 *  A = [1, 2]
 *  B = 1
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  8
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
 *  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 *
 * Explanation 2:
 *
 *  Pick element 2 from end as this is the maximum we can get
 */
public class PickFromBothSides
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve(int[] A, int B) {
        int max = Integer.MIN_VALUE;
        int k = B;
        while (k >= 0) {
            int sum = 0;
            for (int i=0;i<k;i++) {
                sum += A[i];
            }
            // remaining elements to choose from right side after choosing k elements from left side
            int rem = B - k;
            for (int i=A.length-rem;i<A.length;i++) {
                sum += A[i];
            }
            max = Math.max(max, sum);
            k--;
        }
        return max;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    private static int solve1(int[] A, int B) {
        // maintain two arrays prefix sum and suffix sum
        int n = A.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        prefixSum[0] = A[0];
        suffixSum[n-1] = A[n-1];
        for (int i=1;i<n;i++) {
            prefixSum[i] += prefixSum[i-1] + A[i];
            suffixSum[n-i-1] += suffixSum[n-i] + A[n-i-1];
        }
        int k = B, max = Integer.MIN_VALUE;
        while (k >= 0) {
            int rem = B - k;
            int sum;
            if (k-1 < 0) {
                sum = suffixSum[n - rem];
                max = Math.max(max, sum);
                k--;
                continue;
            }
            if (n-rem == n) {
                sum = prefixSum[k-1];
                max = Math.max(max, sum);
                k--;
                continue;
            }
            sum = prefixSum[k-1] + suffixSum[n - rem];
            max = Math.max(max, sum);
            k--;
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] A = {5,-2,3,1,2,6,4,7,8};
        int B = 4;
        System.out.println(solve1(A,B));
    }
}

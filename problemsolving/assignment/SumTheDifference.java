package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 * Given an integer array A of size N.
 *
 * You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the output.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2]
 *
 * Input 2:
 *
 * A = [1]
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
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 *
 * Explanation 2:
 *
 *  Only 1 subsequence of 1 element is formed.
 */
public class SumTheDifference
{

    /**
     * TC = O(n * 2^n), SC = O(1)
     * This will give TLE
     */
    private static int solve(int[] A) {
        List<List<Integer>> res = generateSubsequence(A);
        int sum = 0;
        for (int i=0;i<res.size();i++) {
            int diff = findMaxMinDiff(res.get(i));
            sum += diff;
        }
        return sum % 1000000007;
    }

    private static int findMaxMinDiff(List<Integer> list) {
        if (list.size() == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0;i<list.size();i++) {
            min = Math.min(min, list.get(i));
            max = Math.max(max, list.get(i));
        }
        return max-min;
    }

    private static List<List<Integer>> generateSubsequence(int[] A) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        generateAllSubsequences(A, 0, curr, out);
        return out;
    }

    private static void generateAllSubsequences(int[] A, int pos, List<Integer> curr, List<List<Integer>> out) {
        for (int i=pos;i<A.length;i++) {
            curr.add(A[i]);
            out.add(new ArrayList<>(curr));
            generateAllSubsequences(A, i+1, curr, out);
            curr.remove(curr.size()-1);
        }
    }

    /**
     * TC = O(nlogn), SC = O(1)
     * This will give TLE
     */
    private static int solve1(int[] A) {
        int sum = 0;
        Arrays.sort(A);
        for (int i=0;i<A.length;i++) {
            // where 2 ^ A.length - i - 1 represents the no. of elements greater
            // than the current element A[i]
            int min = A[i] * (int)Math.pow(2, A.length - i - 1);
            // where 2 ^ i represents the no. of elements lesser than the current
            // element A[i]
            int max = A[i] * (int)Math.pow(2, i);
            sum += max - min;
        }
        return sum % 1000000007;
    }

    /**
     * TC = O(nlogn), SC = O(1)
     */
    private static int solve2(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        long maxSum = 0, minSum = 0;
        long sum = 0;
        for (int i=0;i<A.length;i++) {
            minSum = (A[i] * pow(2, A.length - i - 1, mod)) % mod;
            maxSum = (A[i] * pow(2, i, mod)) % mod;
            sum = (sum + (maxSum - minSum + mod) % mod) % mod;
        }
        return (int)sum;
    }

    private static long pow(int a, int b, int mod) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % mod;
        }
        long temp = pow(a, b/2, mod);
        if (b % 2 == 0) {
            return (temp * temp) % mod;
        }
        return (a * temp * temp) % mod;
    }

    public static void main(String[] args)
    {
        int[] A = {3,2,5};
        System.out.println(solve2(A));
    }
}

package problemsolving.homework;

/**
 * Problem Description
 *
 * Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array
 *
 * and atleast one occurrence of the minimum value of the array.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 2000
 *
 *
 * Input Format
 *
 * First and only argument is vector A
 *
 *
 * Output Format
 *
 * Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3]
 *
 * Input 2:
 *
 * A = [2]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
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
 *  Only choice is to take both elements.
 *
 * Explanation 2:
 *
 *  Take the whole array.
 */
public class ClosestMinMax
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve(int[] A) {
        // find max and min
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++) {
            int currMax = Integer.MIN_VALUE, currMin = Integer.MAX_VALUE;
            for (int j=i;j<A.length;j++) {
                // keep track of the current min and current max and compare it with global min and global max
                if (A[j] > currMax) {
                    currMax = A[j];
                }
                if (A[j] < currMin) {
                    currMin = A[j];
                }
                if (currMax == max && currMin == min) {
                    minLen = Math.min(minLen, j-i+1);
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args)
    {
        int[] A = {343,291,963,165,152};
        System.out.println(solve(A));
    }
}

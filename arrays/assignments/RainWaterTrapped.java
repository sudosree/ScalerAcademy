package arrays.assignments;

/**
 * Problem Description
 *
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 *
 *
 * Input Format
 *
 * First and only argument is the vector A
 *
 *
 * Output Format
 *
 * Return one integer, the answer to the question
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [0, 1, 0, 2]
 *
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 1
 *
 * Output 2:
 *
 * 0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 *
 * Explanation 2:
 *
 * No water is trapped.
 */
public class RainWaterTrapped
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    public static int trap(final int[] A) {
        int total_water_trapped = 0;
        for (int i=1;i<A.length-1;i++) {
            int left_max = Integer.MIN_VALUE, right_max = Integer.MIN_VALUE;
            for (int j=0;j<=i;j++) {
                if (A[j] > left_max) {
                    left_max = A[j];
                }
            }
            for (int j=i;j<A.length;j++) {
                if (A[j] > right_max) {
                    right_max = A[j];
                }
            }
            // water trapped above a building
            int water_trapped = Math.min(left_max, right_max) - A[i];
            total_water_trapped += water_trapped;
        }
        return total_water_trapped;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public static int trap1(final int[] A) {
        int total_water_trapped = 0, n = A.length;
        // prefix left max array
        int[] left_max = new int[n];
        // suffix right max array
        int[] right_max = new int[n];
        left_max[0] = A[0];
        right_max[n-1] = A[n-1];
        for (int i=1;i<n;i++) {
            left_max[i] = Math.max(left_max[i-1], A[i]);
            right_max[n - i - 1] = Math.max(right_max[n - i], A[n - i - 1]);
        }
        for (int i=0;i<n;i++) {
            int l = left_max[i];
            int r = right_max[i];
            int water_trapped = Math.min(l,r) - A[i];
            total_water_trapped += water_trapped;
        }
        return total_water_trapped;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    public static int trap2(final int[] A) {
        int total_water_trapped = 0, n = A.length;
        int max_height = Integer.MIN_VALUE, max_index = -1;
        for (int i=0;i<n;i++) {
            if (A[i] > max_height) {
                max_height = A[i];
                max_index = i;
            }
        }
        // calculate the left max for each building on the left side of the max building
        // right max for all the building on the left side of the max building will be the max building itself
        int left_max = Integer.MIN_VALUE;
        for (int i=0;i<max_index;i++) {
            left_max = Math.max(left_max, A[i]);
            int water_trapped = Math.min(left_max, max_height) - A[i];
            total_water_trapped += water_trapped;
        }

        // calculate the right max for each building on the right side of the max building
        // left max for all the building on the right side of the max building will be the max building itself
        int right_max = Integer.MIN_VALUE;
        for (int i=n-1;i>max_index;i--) {
            right_max = Math.max(right_max, A[i]);
            int water_trapped = Math.min(max_height, right_max) - A[i];
            total_water_trapped += water_trapped;
        }

        return total_water_trapped;
    }

    public static void main(String[] args)
    {
        int[] A = {};
        System.out.println(trap1(A));
        System.out.println(trap2(A));
    }
}

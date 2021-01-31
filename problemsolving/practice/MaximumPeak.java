package problemsolving.practice;

import java.util.*;

/**
 * Given peaks of heights of mountains. Find the maximum peak you can see from both the
 * left and right side standing in the current peak.
 */
public class MaximumPeak
{
    private static int[][] maxPeak(int[] A) {
        int[][] peaks = new int[2][A.length];
        // prefix max array
        int[] leftPeak = new int[A.length];
        // suffix max array
        int[] rightPeak = new int[A.length];
        // for the first mountain peak, you cannot see any mountain peak on your left side
        leftPeak[0] = -1;
        // for the last mountain peak, you cannot see any mountain peak on your right side
        rightPeak[A.length-1] = -1;
        int max_left = A[0], max_right = A[A.length-1];
        for (int i=1;i<A.length;i++) {
            leftPeak[i] = max_left;
            max_left = Math.max(max_left, A[i]);
            rightPeak[A.length - 1 - i] = max_right;
            max_right = Math.max(max_right, A[A.length - 1 - i]);
        }
        peaks[0] = leftPeak;
        peaks[1] = rightPeak;
        return peaks;
    }

    public static void main(String[] args)
    {
        int[] A = {4,7,2,4,9,10,1,4,7,3};
        System.out.println(Arrays.deepToString(maxPeak(A)));
    }
}

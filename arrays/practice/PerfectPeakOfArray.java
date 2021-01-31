package arrays.practice;

public class PerfectPeakOfArray
{
    public int perfectPeak(int[] A) {
        int n = A.length;
        int[] right_min = new int[n];
        int[] left_max = new int[n];
        right_min[n-1] = A[n-1];
        for (int i=n-2;i>=0;i--) {
            right_min[i] = Math.min(right_min[i+1], A[i]);
        }
        left_max[0] = A[0];
        for (int i=1;i<n;i++) {
            left_max[i] = Math.max(left_max[i-1], A[i]);
        }
        for (int i=1;i<n-1;i++) {
            if (A[i] > left_max[i-1] && A[i] < right_min[i+1]) {
                return 1;
            }
        }
        return 0;
    }
}

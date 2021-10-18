package arrays.practice;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(intervals, new MySortComparator());
        int end = intervals[0][1];
        int count = 0;
        for (int i=1; i<n; i++) {
            // there is an overlapping
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    class MySortComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return 0;
            }
            return a[0] < b[0] ? -1 : 1;
        }
    }
}

package sorting.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    /**
     * TC = O(nlogn), SC = O(n) (for sorting)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        // sort the intervals based on their start time
        Arrays.sort(intervals, new IntervalComparator());
        List<int[]> ans = new ArrayList<>();
        int[] prevInterval = intervals[0];
        ans.add(prevInterval);

        for (int i=0;i<intervals.length;i++) {
            int[] currInterval = intervals[i];
            // if the start time of the current interval is less or equal to
            // the end time of the previous interval then there is a overlapp
            if (currInterval[0] <= prevInterval[1]) {
                // then check which intervals end time is maximum
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                ans.add(currInterval);
                prevInterval = currInterval;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

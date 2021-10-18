package sorting.practice;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        // add all the intervals ending before the new interval
        int i;
        for (i=0; i<intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[1] < newInterval[0]) {
                ans.add(currInterval);
            } else {
                break;
            }
        }
        // check for overlapping intervals and create a merged new interval
        int j;
        for (j=i;j<intervals.length;j++) {
            int[] currInterval = intervals[j];
            if (currInterval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], currInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currInterval[1]);
            } else {
                break;
            }
        }
        ans.add(newInterval);
        for (int k=j;k<intervals.length;k++) {
            ans.add(intervals[k]);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        // first add all the intervals before the new interval
        int i=0;
        for (i=0; i<n; i++) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else {
                break;
            }
        }
        int j;
        int start = newInterval[0];
        int end = newInterval[1];
        for (j=i; j<n; j++) {
            int[] interval = intervals[j];
            // check if there is an overlapp
            if (start <= interval[1] && end >= interval[0]) {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            } else {
                break;
            }
        }
        res.add(new int[]{start, end});
        for (int k=j; k<n; k++) {
            res.add(intervals[k]);
        }
        int[][] ans = new int[res.size()][2];
        for (int p=0; p<res.size(); p++) {
            ans[p] = res.get(p);
        }
        return ans;
    }
}

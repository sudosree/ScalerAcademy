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
}

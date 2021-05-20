package greedy.assignment;

import java.util.Arrays;
import java.util.Comparator;

public class FinishMaximumJobs {

    /**
     * TC = O(nlogn)
     */
    public int solve(int[] A, int[] B) {
        Activity[] activities = new Activity[A.length];
        for (int i=0;i<A.length;i++) {
            activities[i] = new Activity(A[i], B[i]);
        }
        Arrays.sort(activities, new SortByFinishTime());
        int count = 1;
        Activity prev = activities[0];
        for (int i=1;i<A.length;i++) {
            Activity curr = activities[i];
            if (curr.start >= prev.finish) {
                count++;
                prev = curr;
            }
        }
        return count;
    }

    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static class SortByFinishTime implements Comparator<Activity> {

        @Override
        public int compare(Activity a, Activity b) {
            return a.finish - b.finish;
        }
    }
}

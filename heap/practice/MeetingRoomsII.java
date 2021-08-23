package heap.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        // add the end time of the first meeting
        pq.offer(intervals[0][1]);

        for (int i=1; i<intervals.length; i++) {
            int endTime = pq.peek();
            // check the end time of the meeting, if it is <= start
            // time of the current meeting then this meeting room can be allocated
            // to the current meeting
            if (endTime <= intervals[i][0]) {
                pq.poll();
            }
            // in case a new meeting room is required add the new meeting room with the end time of
            // the current meeting , also need to update the end time of the meeting in case if
            // existing meeting room needs to be allocated
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

    static class IntervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }
}

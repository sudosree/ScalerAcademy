package arrays.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |intervals| <= 105
 *
 *
 * Input Format
 *
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 *
 * Return the vector of intervals after merging
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 *
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 *
 * Output 2:
 *
 *  [ [1, 9] ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 *
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 */
public class MergeIntervals
{

    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    /**
     * TC = O(n)
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();

        if (newInterval.start > newInterval.end) {
            int t = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = t;
        }

        // case1: when the list is empty, new interval will be the answer
        if (intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }

        // case2: when the new interval comes before all the other intervals
        if (newInterval.end < intervals.get(0).start) {
            ans.add(newInterval);
            for (int i=0;i<intervals.size();i++) {
                ans.add(intervals.get(i));
            }
            return ans;
        }

        // case3: when the new interval comes after all the other intervals
        if (intervals.get(intervals.size()-1).end < newInterval.start) {
            for (int i=0;i<intervals.size();i++) {
                ans.add(intervals.get(i));
            }
            ans.add(newInterval);
            return ans;
        }

        // when some intervals from the list comes before the new interval i.e there is no overlapping
        int i=0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i));
            i++;
        }

        int start_time = Integer.MAX_VALUE, end_time = Integer.MIN_VALUE;

        // case4: when there is an overlapping interval with the new interval then merge the interval
        while (i < intervals.size() && checkOverlap(intervals.get(i), newInterval)) {
            start_time = Math.min(start_time, Math.min(intervals.get(i).start, newInterval.start));
            end_time = Math.max(end_time, Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        if (start_time != Integer.MAX_VALUE) {
            ans.add(new Interval(start_time, end_time));
        }

        // case5: when the new interval doesn't overlap with any of the intervals in the list and
        // it will lie in between two intervals
        if(i-1 >= 0 && i < intervals.size() &&
           newInterval.start > intervals.get(i-1).end &&
           newInterval.end < intervals.get(i).start) {
            ans.add(newInterval);
        }

        // after all the above cases add the remaining intervals as they do not overlap with the new interval
        // and they comes after the new interval
        while (i < intervals.size()) {
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }

    private static boolean checkOverlap(Interval int1, Interval int2) {
        int a = int1.start, b = int1.end;
        int c = int2.start, d = int2.end;
        if (a <= c && b >= d) {
            return true;
        }
        if (c <= a && d >= b) {
            return true;
        }
        if (a <= c && c <= b) {
            return true;
        }
        if (c <= a && a <= d) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(8,10));
        /*intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));*/
        Interval newInterval = new Interval(3,6);
        ArrayList<Interval> ans = insert(intervals, newInterval);
        for (int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i).start + " " + ans.get(i).end + "\n");
        }
    }
}

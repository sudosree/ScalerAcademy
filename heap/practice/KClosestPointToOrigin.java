package heap.practice;

import java.util.*;

public class KClosestPointToOrigin {

    /**
     * TC = O(nlogn)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        // sort the array based
        Arrays.sort(points, new MyComparator());
        List<int[]> ans = new ArrayList<>();
        for (int i=0;i<k;i++) {
            ans.add(points[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * TC = O(n + klogn) = O(klogn)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest1(int[][] points, int k) {
        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        for (int i=0;i<points.length;i++) {
            pq.offer(points[i]);
        }
        int[][] ans = new int[k][2];
        for (int i=0;i<k;i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] p1, int[] p2) {
            return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
        }
    }
}

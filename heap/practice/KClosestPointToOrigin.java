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
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new MinDistComparator());
        for (int[] point : points) {
            minHeap.offer(point);
        }
        List<int[]> res = new ArrayList<>();
        while (k > 0) {
            res.add(minHeap.poll());
            k--;
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new MaxDistComparator());
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][];
        int i=0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }

    static class MaxDistComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            int dist1 = a[0] * a[0] + a[1] * a[1];
            int dist2 = b[0] * b[0] + b[1] * b[1];
            if (dist1 == dist2) {
                return 0;
            }
            return dist1 > dist2 ? -1 : 1;
        }
    }

    static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] p1, int[] p2) {
            return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
        }
    }

    static class MinDistComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            int dist1 = a[0] * a[0] + a[1] * a[1];
            int dist2 = b[0] * b[0] + b[1] * b[1];
            if (dist1 == dist2) {
                return 0;
            }
            return dist1 < dist2 ? -1 : 1;
        }
    }
}

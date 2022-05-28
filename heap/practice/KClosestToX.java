package heap.practice;

import java.util.*;

public class KClosestToX {

    /**
     * TC = O(n) + O(k) + O((n-k)*logk) = O(nlogk), SC = O(n) + O(k) = O(n)
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        // find the distance of every no. from x
        for (int i=0; i<arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            map.put(arr[i], dist);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            pq.offer(arr[i]);
        }
        for (int i=k; i<arr.length; i++) {
            int dist1 = map.get(arr[i]);
            int dist2 = map.get(pq.peek());
            if (dist1 < dist2) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }

    private static Map<Integer, Integer> map;

    /**
     * TC = O(n) + O(n) + O(nlogn) + O(klogk) = O(nlogn)
     * SC = O(n) + O(n) = O(n)
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int dist = Math.abs(arr[i] - x);
            map.put(arr[i], dist);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        Collections.sort(res, new MyComparator());
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<k; i++) {
            ans.add(res.get(i));
        }
        Collections.sort(ans);
        return ans;
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (map.get(a) == map.get(b)) {
                return 0;
            }
            return map.get(a) < map.get(b) ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9};
        int k = 3, x = 7;
        System.out.println(findClosestElements1(nums, k, x));
    }
}

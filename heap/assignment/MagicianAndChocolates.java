package heap.assignment;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    /**
     * TC = O(n + Alogn) = O(Alogn)
     */
    public int nchoc(int A, int[] B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        for (int i=0;i<B.length;i++) {
            maxHeap.offer(B[i]);
        }
        int count = 0, mod = 1000000007;
        while (A > 0) {
            int choc = maxHeap.poll();
            count = (count % mod + choc % mod) % mod;
            maxHeap.offer(Math.floorDiv(choc,2));
            A--;
        }
        return count;
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
}

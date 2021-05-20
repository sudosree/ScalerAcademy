package heap.assignment;

import java.util.PriorityQueue;

public class MinimumArraySumAfterBNegation {

    /**
     * TC = O(n + Blogn) = O(Blogn)
     */
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<A.length;i++) {
            pq.offer(A[i]);
        }
        while (B > 0) {
            int num = pq.poll();
            pq.offer(-num);
            B--;
        }
        int sum = 0;
        while (pq.size() > 0) {
            sum += pq.poll();
        }
        return sum;
    }
}

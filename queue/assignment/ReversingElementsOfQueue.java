package queue.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class ReversingElementsOfQueue {

    /**
     * TC = O(n)
     */
    public int[] solve(int[] A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        // insert first B elements into the queue
        int i;
        for (i=0;i<B;i++) {
            queue.offer(A[i]);
        }
        while (!queue.isEmpty()) {
            A[--i] = queue.poll();
        }
        return A;
    }
}

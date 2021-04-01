package queue.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {

    public int solve(int[] A, int[] B) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i=0;i<A.length;i++) {
            queue.offer(A[i]);
        }
        for (int i=0;i<B.length;i++) {
            while (!queue.isEmpty() && queue.peek() != B[i]) {
                queue.offer(queue.poll());
                count++;
            }
            if (queue.peek() == B[i]) {
                queue.poll();
                count++;
            }
        }
        return count;
    }
}

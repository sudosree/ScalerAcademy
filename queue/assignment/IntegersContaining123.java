package queue.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IntegersContaining123 {

    /**
     * TC = O(n), SC = O(n)
     */
    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        int count = 0;
        while (count != A) {
            int n = queue.poll();
            ans.add(n);
            count++;
            queue.offer(10 * n + 1);
            queue.offer(10 * n + 2);
            queue.offer(10 * n + 3);
        }
        return ans;
    }
}

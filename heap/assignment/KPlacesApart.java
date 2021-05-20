package heap.assignment;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {

    /**
     * TC = O(nlogB), SC = O(B)
     */
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0;i<A.size();i++) {
            pq.offer(A.get(i));
            if (pq.size() > B) {
                ans.add(pq.poll());
            }
        }
        while (pq.size() > 0) {
            ans.add(pq.poll());
        }
        return ans;
    }
}

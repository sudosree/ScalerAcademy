package queue.assignment;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMax {

    /**
     * TC = O(n), SC = O(n)
     */
    public int solve(int[] A, int B) {
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        int n = A.length;
        // min array will store the minimum element of every window
        int[] min = new int[n-B+1];
        // max array will store the maximum element of every window
        int[] max = new int[n-B+1];

        for (int i=0;i<B;i++) {
            // for minimum
            if (q1.isEmpty() || A[i] >= q1.peekLast()) {
                q1.offer(A[i]);
            } else {
                while (!q1.isEmpty() && A[i] < q1.peekLast()) {
                    q1.pollLast();
                }
                q1.offer(A[i]);
            }

            // for maximum
            if (q2.isEmpty() || A[i] <= q2.peekLast()) {
                q2.offer(A[i]);
            } else {
                while (!q2.isEmpty() && A[i] > q2.peekLast()) {
                    q2.pollLast();
                }
                q2.offer(A[i]);
            }
        }

        int i=1;
        for (i=1;i<n-B+1;i++) {
            min[i-1] = q1.peek();
            max[i-1] = q2.peek();
            if (A[i-1] == q1.peek()) {
                q1.poll();
            }
            if (A[i-1] == q2.peek()) {
                q2.poll();
            }
            // for minimum
            if (q1.isEmpty() || A[i+B-1] >= q1.peekLast()) {
                q1.offer(A[i+B-1]);
            } else {
                while (!q1.isEmpty() && A[i+B-1] < q1.peekLast()) {
                    q1.pollLast();
                }
                q1.offer(A[i+B-1]);
            }

            // for maximum
            if (q2.isEmpty() || A[i+B-1] <= q2.peekLast()) {
                q2.offer(A[i+B-1]);
            } else {
                while (!q2.isEmpty() && A[i+B-1] > q2.peekLast()) {
                    q2.pollLast();
                }
                q2.offer(A[i+B-1]);
            }
        }
        min[i-1] = q1.peek();
        max[i-1] = q2.peek();

        long sum = 0;
        int mod = 1000000007;
        for (int k=0;k<n-B+1;k++) {
            int curr_sum = (min[k] + max[k]) % mod;
            sum += curr_sum;
        }
        while (sum <= 0) {
            sum = sum + mod;
        }
        return (int)(sum % mod);
    }
}

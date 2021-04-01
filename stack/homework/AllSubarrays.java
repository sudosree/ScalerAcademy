package stack.homework;

import java.util.Stack;

public class AllSubarrays {

    public static int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Stack<Integer> l = new Stack<>();
        Stack<Integer> r = new Stack<>();

        for (int i=0,j=A.length-1; i<A.length && j>=0; i++,j--) {
            // consider each element A[i] as second largest element
            // find the next larger element on it left and right side
            while (!l.empty() && A[i] >= A[l.peek()]) {
                l.pop();
            }
            if (l.empty()) {
                left[i] = 0;
            } else {
                left[i] = A[l.peek()];
            }
            l.push(i);

            while (!r.empty() && A[j] >= A[r.peek()]) {
                r.pop();
            }
            if (r.empty()) {
                right[j] = 0;
            } else {
                right[j] = A[r.peek()];
            }
            r.push(j);
        }

        for (int i=0;i<A.length;i++) {
            if (left[i] != 0) {
                max = Math.max(max, A[i] ^ left[i]);
            }
            if (right[i] != 0) {
                max = Math.max(max, A[i] ^ right[i]);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] A = {1,1};
        System.out.println(solve(A));
    }
}

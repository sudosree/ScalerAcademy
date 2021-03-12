package stack.assignment;

import java.util.Stack;

public class MaxMinStack {

    public static int solve(int[] A) {
        int n = A.length;

        int[] small_left = nearestSmallerLeft(A);
        int[] small_right = nearestSmallerRight(A);
        int[] large_left = nearestLargerLeft(A);
        int[] large_right = nearestLargerRight(A);

        int mod = 1000000007;
        long total = 0;

        for (int i=0;i<n;i++) {
            // find the nearest smaller on the left side
            int l1 = small_left[i];
            // find the nearest smaller on the right side
            int r1 = small_right[i];
            // find the nearest larger on the left side
            int l2 = large_left[i];
            // find the nearest larger on the right side
            int r2 = large_right[i];

            //no. of subarrays in which A[i] is minimum
            long min = 1L * (i - l1) * (r1 - i);
            //no. of subarrays in which A[i] is maximum
            long max = 1L * (i - l2) * (r2 - i);

            total = total + (A[i] * (max - min));
        }
        return (int)(total % mod);
    }

    private static int[] nearestSmallerLeft(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i=0; i<A.length; i++) {
            // calculate the nearest smaller element on the left side i.e. A[k] < A[i]
            while (!stack.empty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) {
                ans[i] = -1;
            } else if (A[i] > A[stack.peek()]) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nearestSmallerRight(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i=A.length-1; i>=0; i--) {
            // calculate the nearest smaller element on the right side i.e. A[k] <= A[j]
            while (!stack.empty() && A[i] < A[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) {
                ans[i] = A.length;
            } else if (A[i] >= A[stack.peek()]) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nearestLargerLeft(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i=0; i<A.length; i++) {
            // calculate the nearest larger element on the left side i.e. A[k] > A[i]
            while (!stack.empty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) {
                ans[i] = -1;
            } else if (A[i] < A[stack.peek()]) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nearestLargerRight(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i=A.length-1;i>=0;i--) {
            // calculate the nearest larger element on the right side i.e. A[k] >= A[j]
            while (!stack.empty() && A[i] > A[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) {
                ans[i] = A.length;
            } else if (A[i] <= A[stack.peek()]) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 3, 8};
        System.out.println(solve(A));

        StringBuilder sb = new StringBuilder("abc");
        StringBuilder sb_rev = sb.reverse();
        System.out.println(sb.append(sb.reverse()).toString());
    }
}

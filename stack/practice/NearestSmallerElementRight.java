package stack.practice;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementRight {

    private static int[] solve(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=A.length-1;i>=0;i--) {
            while (!stack.empty() && A[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                res[i] = -1;
            } else if (A[i] > stack.peek()) {
                res[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(solve(A)));
    }
}

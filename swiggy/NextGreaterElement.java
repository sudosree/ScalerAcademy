package swiggy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    private static int[] findNextGreater(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=A.length-1;i>=0;i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (A[stack.peek()] > A[i]) {
                ans[i] = A[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {11,13,21,3};
        System.out.println(Arrays.toString(findNextGreater(A)));
    }
}

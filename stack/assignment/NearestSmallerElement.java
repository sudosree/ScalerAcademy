package stack.assignment;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public static int[] prevSmaller(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<A.length;i++) {
            if (stack.empty()) {
                res[i] = -1;
            } else if (A[i] > stack.peek()) {
                res[i] = stack.peek();
            } else {
                while (!stack.empty() && A[i] <= stack.peek()) {
                    stack.pop();
                }
                if (stack.empty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(A)));
    }
}

package stack.assignment;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /**
     * TC = O(n), SC = O(n)
     */
    public static int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack_left = new Stack<>();
        Stack<Integer> stack_right = new Stack<>();

        for (int i=0,j=n-1; i<n && j>=0; i++,j--) {
            // calculate the nearest smaller element on the left side
            while (!stack_left.empty() && A[i] <= A[stack_left.peek()]) {
                stack_left.pop();
            }
            if (stack_left.empty()) {
                left[i] = -1;
            } else if (A[i] > A[stack_left.peek()]) {
                left[i] = stack_left.peek();
            }
            stack_left.push(i);

            // calculate the nearest smaller element on the right side
            while (!stack_right.empty() && A[j] <= A[stack_right.peek()]) {
                stack_right.pop();
            }
            if (stack_right.empty()) {
                right[j] = n;
            } else if (A[j] > A[stack_right.peek()]) {
                right[j] = stack_right.peek();
            }
            stack_right.push(j);
        }

        int max_area = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            // width of the histograms in the range (left[i], right[i]) exclusive
            int width = right[i] - left[i] - 1;
            int curr_area = A[i] * width;
            if (curr_area > max_area) {
                max_area = curr_area;
            }
        }
        return max_area;
    }

    public static int largestRectangleArea1(int[] A) {
        int max_area = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            int left = i, right = i;
            while (left >= 0 && A[left] >= A[i]) {
                left = left-1;
            }
            while (right < A.length && A[right] >= A[i]) {
                right = right+1;
            }
            max_area = Math.max(max_area, (right - left - 1) * A[i]);
        }
        return max_area;
    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        for (int i=0;i<heights.length;i++) {
            int minHeight = heights[i];
            for (int j=i;j<heights.length;j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea3(int[] heights) {
        int maxArea = 0, n = heights.length;
        // will store all the elements in increasing order
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i<n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // pop the element from the stack and calculate the area of the
                // largest rectangle that can be formed with the current element
                int currentHeight = heights[stack.pop()];
                // left and right limit represents the index of the nearest smaller no. to
                // the left and right side of the current element
                int leftLimit = stack.peek();
                int rightLimit = i;
                int width = rightLimit - leftLimit - 1;
                maxArea = Math.max(maxArea, width * currentHeight);
            }
            // push the current index to the stack
            stack.push(i);
        }

        // if there are still elements present in the stack
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int leftLimit = stack.peek();
            int rightLimit = n;
            int width = rightLimit - leftLimit - 1;
            maxArea = Math.max(maxArea, width * currentHeight);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
        System.out.println(largestRectangleArea1(A));
    }
}

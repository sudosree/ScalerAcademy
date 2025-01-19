package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
 *
 * Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
 *
 * Refer to the given example for clarity.
 *
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A|, B <= 106
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 3, -1, -3, 5, 3, 6, 7]
 *  B = 3
 *
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 *  B = 6
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [3, 3, 5, 5, 6, 7]
 *
 * Output 2:
 *
 *  [7, 7, 7, 7]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Window position     | Max
 *  --------------------|-------
 *  [1 3 -1] -3 5 3 6 7 | 3
 *  1 [3 -1 -3] 5 3 6 7 | 3
 *  1 3 [-1 -3 5] 3 6 7 | 5
 *  1 3 -1 [-3 5 3] 6 7 | 5
 *  1 3 -1 -3 [5 3 6] 7 | 6
 *  1 3 -1 -3 5 [3 6 7] | 7
 *
 * Explanation 2:
 *
 *  Window position     | Max
 *  --------------------|-------
 *  [1 2 3 4 2 7] 1 3 6 | 7
 *  1 [2 3 4 2 7 1] 3 6 | 7
 *  1 2 [3 4 2 7 1 3] 6 | 7
 *  1 2 3 [4 2 7 1 3 6] | 7
 */
public class SlidingWindowMaximum
{
    private static int[] slidingMaximum(int[] A, int B) {
        int n = A.length;
        if (B > n) {
            int max = Integer.MIN_VALUE;
            for (int i=0;i<n;i++) {
                max = Math.max(max, A[i]);
            }
            return new int[]{max};
        }
        // there will be total n-B+1 windows in the array of size B, so total
        // no. of maximum elements will be of size n-B+1 only, as we have to find the
        // no. of maximum in each window
        int[] ans = new int[n-B+1];

        Deque<Integer> deque = new ArrayDeque<>();
        // consider the first window
        for (int i=0;i<B;i++) {
            // when the element A[i] in the current window is greater than the
            // elements present in the deque, then remove those elements until A[i]
            // is smaller than the elements in the deque
            while (deque.peekLast() != null && A[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(A[i]);
        }

        for (int i=1;i<n-B+1;i++) {
            // when you slide the window, remove the first element of that window if the
            // first element in the deque is equal to the previous element A[i-1]
            if (deque.peekFirst() != null && deque.peekFirst() == A[i-1]) {
                ans[i-1] = deque.pollFirst();
            }
            else if (deque.peekFirst() != null && deque.peekFirst() != A[i-1]) {
                ans[i-1] = deque.peekFirst();
            }
            // check if the new element will be the max or not
            int new_element = A[i+B-1];
            while (deque.peekLast() != null && new_element > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(new_element);
        }
        ans[ans.length-1] = deque.peekFirst() != null ? deque.peekFirst() : 0;
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> queue = new LinkedList<>();
        // add the first k elements in the queue
        for (int i=0; i<k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
        }
        ans[0] = queue.peek();
        for (int i=1; i<n-k+1; i++) {
            // if the first element of the queue equals the nums[i-1]
            // then remove it from the queue
            if (queue.peek() == nums[i-1]) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i+k-1] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[i+k-1]);
            ans[i] = queue.peek();
        }
        return ans;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // in total there will be n-k+1 windows
        int[] ans = new int[n-k+1];
        // will hold the elements in sorted decreasing order
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<k; i++) {
            // if the queue is not empty and the current element is greater than the last element then
            // remove the last element as it will never contribute to the largest element in any future windows
            // keep on removing the last elements from the queue until queue becomes empty or nums[i] is less than the
            // last element
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            // either nums[i] is smaller than the last element so nums[i] will be the potential candidate in the future windows
            // or nums[i] is greater than all the other elements in the queue
            queue.offer(nums[i]);
        }
        // first element of the queue will always be the largest element in the current window
        ans[0] = queue.peek();
        for (int i=1; i<n-k+1; i++) {
            // check if the element that got removed out from the window is equal to the first
            // element in the queue, if yes then remove the element from the queue
            if (!queue.isEmpty() && nums[i-1] == queue.peek()) {
                queue.poll();
            }
            else {
                while (!queue.isEmpty() && nums[i+k-1] > queue.peekLast()) {
                    queue.pollLast();
                }
                queue.offer(nums[i+k-1]);
            }
            ans[i] = queue.peek();
        }
        return ans;
    }

    public static void main(String[] args)
    {
//        int[] A = {7,6,3,4,2,8,5,4};
//        int B = 9;
//        System.out.println(Arrays.toString(slidingMaximum(A, B)));
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow2(nums, k));
    }
}

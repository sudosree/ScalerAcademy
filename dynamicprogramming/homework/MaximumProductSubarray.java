package dynamicprogramming.homework;

public class MaximumProductSubarray {

    public int maxProduct(final int[] A) {
        int max_so_far = A[0], min_so_far = A[0];
        int result = max_so_far;
        for (int i=1;i<A.length;i++) {
            int curr = A[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        return result;
    }
}

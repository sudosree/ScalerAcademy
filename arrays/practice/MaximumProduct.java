package arrays.practice;

public class MaximumProduct {

    public static int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i=1;i<nums.length;i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        return result;
    }

    public static int maxProduct1(int[] nums) {
        int max_prod = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            int prod = 1;
            for (int j=i;j<nums.length;j++) {
                prod *= nums[j];
                if (prod > max_prod) {
                    max_prod = prod;
                }
            }
        }
        return max_prod;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }
}

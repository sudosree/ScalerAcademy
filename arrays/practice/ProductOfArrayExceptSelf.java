package arrays.practice;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // left array contains the product of all the elements to the
        // left of an element
        int[] left = new int[n];

        // right array contains the product of all the elements to the
        // right of an element
        int[] right = new int[n];

        // since there are no elements to the left of the element at index 0
        // so left[0] = 1
        left[0] = 1;
        for (int i=1;i<n;i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        //since there are no elements to the right of the element at index n-1
        // so right[n-1] = 1
        right[n-1] = 1;
        for (int i=n-2;i>=0;i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] answer = new int[n];
        for (int i=0;i<n;i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i=1;i<n;i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i=n-1;i>=0;i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        return answer;
    }
}

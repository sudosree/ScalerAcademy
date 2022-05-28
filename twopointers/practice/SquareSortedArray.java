package twopointers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareSortedArray {

    private static int[] squareSortedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = n-1;
        int left = 0, right = n-1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (rightSquare >= leftSquare) {
                ans[i--] = rightSquare;
                right--;
            } else {
                ans[i--] = leftSquare;
                left++;
            }
        }
        return ans;
    }

    private static int[] squareArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n-1;
        int i = n-1;
        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (r >= l) {
                ans[i--] = r;
                right--;
            } else {
                ans[i--] = l;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 2, 3};
        System.out.println(Arrays.toString(squareSortedArray(nums)));
        System.out.println(Arrays.toString(squareArray(nums)));
    }
}

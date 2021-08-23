package twopointers.practice;

import java.util.Arrays;

public class TwoSumSmaller {

    private static int twoSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int t = 12;
        System.out.println(twoSumSmaller(nums, t));
    }
}

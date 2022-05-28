package twopointers.practice;

public class RemoveDuplicatesFromArray {

    private static int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            // no duplicates then add the nums[right]
            // to left+1
            if (nums[right] != nums[left]) {
                nums[left+1] = nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 11};
        System.out.println(removeDuplicates(nums));
    }
}

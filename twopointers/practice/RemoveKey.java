package twopointers.practice;

public class RemoveKey {

    private static int removeKey(int[] nums, int key) {
        int n = nums.length;
        int left = -1, right = 0;
        while (right < n) {
            if (nums[right] != key) {
                nums[left+1] = nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 2, 2, 1};
        int key = 2;
        System.out.println(removeKey(nums, key));
    }
}

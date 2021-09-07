package arrays.practice;

public class MissingNo {

    private static int findMissingNo(int[] nums) {
        int n = nums.length;
        for (int i=0;i<n;i++) {
            if (nums[i] != i+1) {
                while (nums[i] < n+1 && nums[i] != i+1) {
                    int t = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = t;
                }
            }
        }
        for (int i=0;i<n;i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(findMissingNo(nums));
    }
}

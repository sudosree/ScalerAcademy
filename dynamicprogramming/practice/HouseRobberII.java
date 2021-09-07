package dynamicprogramming.practice;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int max1 = robHelper(nums, 0, n-2);
        int max2 = robHelper(nums, 1, n-1);
        return Math.max(max1, max2);
    }

    private int robHelper(int[] nums, int low, int high) {
        int t1 = 0, t2 = 0;
        for (int i=low; i<=high; i++) {
            int temp = t1;
            t1 = Math.max(nums[i] + t2, t1);
            t2 = temp;
        }
        return t1;
    }

    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(robHelper1(nums, 0, n-2), robHelper1(nums, 1, n-1));
    }

    private int robHelper1(int[] nums, int start, int end) {
        // house adjacent to the current house
        int rob1 = 0;
        // house adjacent to the previous house
        int rob2 = 0;
        for (int i=start; i<=end; i++) {
            int newRob = Math.max(nums[i] + rob2, rob1);
            rob2 = rob1;
            rob1 = newRob;
        }
        return rob1;
    }
}

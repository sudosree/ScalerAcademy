package dynamicprogramming.practice;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        // you cannot find any subsets that sum to the target sum
        if (sum % 2 != 0) {
            return false;
        }
        return canPartitionHelper(nums, 0, sum/2);
    }

    private boolean canPartitionHelper(int[] nums, int index, int targetSum) {
        // base cases, when target sum is zero
        if (targetSum == 0) {
            return true;
        }
        // do not find any subsets
        if (targetSum < 0 || index == nums.length) {
            return false;
        }
        // for each element there are two choices whether we can choose the element or
        // not choose the element

        boolean notChoose = canPartitionHelper(nums, index+1, targetSum);
        boolean choose = canPartitionHelper(nums, index+1, targetSum - nums[index]);
        return notChoose || choose;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][targetSum+1];
        // you can achieve a sum of 0 with no elements
        dp[0][0] = true;

        for (int i=1; i<nums.length+1; i++) {
            for (int j=1; j<targetSum+1; j++) {
                // at each step you have two choices either you can include the element
                // into the subset or not include the element in the subset
                if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][targetSum];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum/2;
        boolean[] dp = new boolean[targetSum+1];
        // you can achieve a sum of 0 with no elements
        dp[0] = true;

        for (int num : nums) {
            for (int j=targetSum; j>=num; j--) {
                // at each step you have two choices either you can include the element
                // into the subset or not include the element in the subset
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[targetSum];
    }
}

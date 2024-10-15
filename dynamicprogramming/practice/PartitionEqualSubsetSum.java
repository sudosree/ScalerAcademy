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

    public boolean canPartition3(int[] nums) {
        int totalSum = 0;
        for (int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        // if the totalSum is not divisible by 2 then return false as it cannot form
        // equal subset sum
        if (totalSum % 2 != 0) {
            return false;
        }
        int subsetSum = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length+1][subsetSum+1];
        return canPartitionHelper(0, subsetSum, nums, memo);
    }

    private boolean canPartitionHelper(int index, int sum, int[] nums, Boolean[][] memo) {
        // if the sum is equal to 0 then return true
        if (sum == 0) {
            return true;
        }
        // if the sum is negative or there are no elements left
        if (sum < 0 || index == nums.length) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        memo[index][sum] = canPartitionHelper(index+1, sum - nums[index], nums, memo) || canPartitionHelper(index+1, sum, nums, memo);
        return memo[index][sum];
    }

    public boolean canPartition4(int[] nums) {
        int totalSum = 0;
        for (int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        // if the totalSum is not divisible by 2 then return false as it cannot form
        // equal subset sum
        if (totalSum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int subsetSum = totalSum / 2;
        boolean[][] dp = new boolean[n+1][subsetSum+1];
        // for sum 0 set dp[i][0] = true
        for (int i=0; i<n+1; i++) {
            dp[i][0] = true;
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<subsetSum+1; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i+1][j - nums[i]] || dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][subsetSum];
    }

    public boolean canPartition5(int[] nums) {
        int totalSum = 0;
        for (int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        // if the totalSum is not divisible by 2 then return false as it cannot form
        // equal subset sum
        if (totalSum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int subsetSum = totalSum / 2;
        boolean[][] dp = new boolean[2][subsetSum+1];
        // for sum 0 set dp[i][0] = true
        for (int i=0; i<2; i++) {
            dp[i][0] = true;
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<subsetSum+1; j++) {
                if (nums[i] <= j) {
                    dp[i & 1][j] = dp[(i+1) & 1][j - nums[i]] || dp[(i+1) & 1][j];
                } else {
                    dp[i & 1][j] = dp[(i+1) & 1][j];
                }
            }
        }
        return dp[0][subsetSum];
    }

    public boolean canPartition6(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        // if the totalSum is not divisible by 2 then return false as it cannot form
        // equal subset sum
        if (totalSum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = subsetSum; j >= 0; j--) {
                if (nums[i] <= j) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }
        return dp[subsetSum];
    }
}

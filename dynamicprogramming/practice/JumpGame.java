package dynamicprogramming.practice;

import java.util.Arrays;

public class JumpGame {

    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }

    private boolean canJumpHelper(int[] nums, int index) {
        // if you reach out of bound then return false
        if (index >= nums.length) {
            return false;
        }
        // if you reach at the last index then return true
        if (index == nums.length-1) {
            return true;
        }
        // no jump is possible
        if (nums[index] == 0) {
            return false;
        }
        int maxJump = nums[index];
        boolean canReach = false;
        while (maxJump > 0) {
            canReach = canReach || canJumpHelper(nums, maxJump + index);
            maxJump--;
        }
        return canReach;
    }

    public boolean canJump1(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJumpHelper(nums, 0, memo);
    }

    private boolean canJumpHelper(int[] nums, int index, int[] memo) {
        // if you reach out of bound then return false
        if (index >= nums.length) {
            return false;
        }
        // if you reach at the last index then return true
        if (index == nums.length-1) {
            return true;
        }
        // no jump is possible
        if (nums[index] == 0) {
            return false;
        }
        if (memo[index] != -1) {
            return memo[index] == 1;
        }

        int maxJump = nums[index];
        boolean canReach = false;
        while (maxJump > 0) {
            canReach = canReach || canJumpHelper(nums, maxJump + index, memo);
            maxJump--;
        }
        memo[index] = canReach ? 1 : 0;
        return memo[index] == 1;
    }

    public boolean canJump2(int[] nums) {
        return canJumpFromPosition(nums, 0);
    }

    private boolean canJumpFromPosition(int[] nums, int position) {
        // if you reach the last index
        if (position == nums.length-1) {
            return true;
        }
        // this is done to avoid the overflow issue
        int furthestJump = Math.min(nums[position] + position, nums.length-1);
        for (int nextPosition = position+1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nums, nextPosition)) {
                return true;
            }
        }
        return false;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    public boolean canJump3(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        return canJumpFromPosition(nums, 0, memo);
    }

    private boolean canJumpFromPosition(int[] nums, int position, Index[] memo) {
        // if you reach the last index
        if (position == nums.length-1) {
            return true;
        }
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        // this is done to avoid the overflow issue
        int furthestJump = Math.min(nums[position] + position, nums.length-1);
        for (int nextPosition = position+1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nums, nextPosition, memo)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump4(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        // the last index is reachable from itself so it is a good index
        memo[memo.length-1] = Index.GOOD;

        for (int i=nums.length-2; i>=0; i--) {
            int furthestJump = Math.min(nums[i] + i, nums.length-1);
            for (int j=i+1; j<=furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    public boolean canJump5(int[] nums) {
        int leftMostGoodIndex = nums.length-1;
        for (int i=nums.length-2; i>=0; i--) {
            // can jump to a good index
            if (i + nums[i] >= leftMostGoodIndex) {
                leftMostGoodIndex = i;
            }
        }
        return leftMostGoodIndex == 0;
    }

    private int[] memo;

    public boolean canJump6(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJumpHelper1(nums, 0);
    }

    private boolean canJumpHelper1(int[] nums, int i) {
        if (i == nums.length-1) {
            return true;
        }
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        // at each index i, the no. of jumps can be made is from 1 to nums[i]
        for (int jumps=1; jumps<= nums[i]; jumps++) {
            boolean res = canJumpHelper1(nums, i + jumps);
            if (res) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }

    public boolean canJump7(int[] nums) {
        int n = nums.length;
        int lastGoodIndex = n-1;
        for (int i=n-2; i>=0; i--) {
            int furthestJump = i + nums[i];
            if (furthestJump >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }
}

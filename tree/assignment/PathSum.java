package tree.assignment;

import tree.TreeNode;

public class PathSum {

    /**
     * TC = O(n), SC = O(n) -> in worst case
     */
    public int hasPathSum1(TreeNode A, int B) {
        return pathSum(A, 0, B) ? 1 : 0;
    }

    private boolean pathSum(TreeNode root, int currSum, int sum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        if (currSum == sum && root.left == null && root.right == null) {
            return true;
        }
        return pathSum(root.left, currSum, sum) ||
                pathSum(root.right, currSum, sum);
    }

    public int hasPathSum2(TreeNode A, int B) {
        return pathSum(A, B) ? 1 : 0;
    }

    private boolean pathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return pathSum(root.left, sum) || pathSum(root.right, sum);
    }

    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}

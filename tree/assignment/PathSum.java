package tree.assignment;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    static class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, targetSum - root.val));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int remSum = p.sum;

            // leaf node and sum is zero
            if (node.left == null && node.right == null && remSum == 0) {
                return true;
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, remSum - node.left.val));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, remSum - node.right.val));
            }
        }
        return false;
    }


}

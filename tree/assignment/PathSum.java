package tree.assignment;

import javafx.util.Pair;
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

    /*static class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }*/

    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, targetSum - root.val));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int remSum = p.getValue();

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

    public boolean hasPathSum4(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            // add all the left nodes starting from the root node to the stack
            while (curr != null) {
                stack.push(new Pair<>(curr, targetSum));
                targetSum -= curr.val;
                curr = curr.left;
            }
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int sum = pair.getValue();
            if (node.left == null && node.right == null && sum == node.val) {
                return true;
            }
            if (node.right != null) {
                curr = node.right;
                targetSum = sum - node.val;
            }
        }
        return false;
    }


}

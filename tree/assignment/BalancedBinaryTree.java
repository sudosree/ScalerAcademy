package tree.assignment;

import tree.TreeNode;

public class BalancedBinaryTree {

    static class TreeInfo {
        int height;
        boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    /**
     * TC = O(n), SC = O(h)
     */
    public int isBalanced(TreeNode A) {
        return isBalancedHelper(A).isBalanced ? 1 : 0;
    }

    private TreeInfo isBalancedHelper(TreeNode root) {
        // if tree is empty then its a balanced binary tree
        if (root == null) {
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedHelper(root.left);
        TreeInfo right = isBalancedHelper(root.right);
        // check if the left and right subtrees are balanced or not
        if (!left.isBalanced) {
            return new TreeInfo(-1, false);
        }
        if (!right.isBalanced) {
            return new TreeInfo(-1, false);
        }
        // if both the left and right subtrees are balanced then check if the parent
        // node is balanced or not
        int leftH = left.height;
        int rightH = right.height;
        if (Math.abs(leftH - rightH) <= 1) {
            return new TreeInfo(Math.max(leftH, rightH) + 1, true);
        }
        // if the parent node is not balanced
        return new TreeInfo(-1, false);
    }

    /**
     * TC = O(n^2) (worst case), SC = O(h)
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.abs(leftH - rightH) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

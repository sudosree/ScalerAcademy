package tree.homework;

import tree.TreeNode;

public class SumBinaryTree {

    public static int solve(TreeNode A) {
        return checkSumBinaryTree(A) ? 1 : 0;
    }

    private static boolean checkSumBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return root.val == leftSum + rightSum && checkSumBinaryTree(root.left) && checkSumBinaryTree(root.right);
    }

    private static int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        return leftSum + rightSum + root.val;
    }

    public static int solve1(TreeNode A) {
        return isSumBinaryTreeHelper(A).isSumBinaryTree ? 1 : 0;
    }

    private static TreeNodeInfo isSumBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return new TreeNodeInfo(0, true);
        }
        if (root.left == null && root.right == null) {
            return new TreeNodeInfo(root.val, true);
        }
        TreeNodeInfo left = isSumBinaryTreeHelper(root.left);
        TreeNodeInfo right = isSumBinaryTreeHelper(root.right);
        if (!left.isSumBinaryTree) {
            return new TreeNodeInfo(-1, false);
        }
        if (!right.isSumBinaryTree) {
            return new TreeNodeInfo(-1, false);
        }
        if (root.val == left.sum + right.sum) {
            return new TreeNodeInfo(left.sum + root.val + right.sum, true);
        }
        return new TreeNodeInfo(-1, false);
    }

    private TreeNodeInfo isSumBinaryTreeHelper1(TreeNode root) {
        // empty tree is a sum binary tree
        if (root == null) {
            return new TreeNodeInfo(0, true);
        }
        // leaf node is a sum binary tree
        if (root.left == null && root.right == null) {
            return new TreeNodeInfo(root.val, true);
        }
        TreeNodeInfo left = isSumBinaryTreeHelper1(root.left);
        TreeNodeInfo right = isSumBinaryTreeHelper1(root.right);
        // if both the left and right subtrees are sum binary tree then check
        // if the current node satisfies the sum binary tree property or not
        if (left.isSumBinaryTree && right.isSumBinaryTree) {
            if (root.val == left.sum + right.sum) {
                return new TreeNodeInfo(root.val + left.sum + right.sum, true);
            }
            return new TreeNodeInfo(0, false);
        }
        return new TreeNodeInfo(0, false);
    }

    static class TreeNodeInfo {

        int sum;
        boolean isSumBinaryTree;

        public TreeNodeInfo(int sum, boolean isSumBinaryTree) {
            this.sum = sum;
            this.isSumBinaryTree = isSumBinaryTree;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        System.out.println(solve(root));
    }
}

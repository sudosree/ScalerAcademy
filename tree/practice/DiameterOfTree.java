package tree.practice;

import tree.TreeNode;

public class DiameterOfTree {

    static class TreeNodeInfo {
        int val;
        int diameter;
        int pathLen;

        TreeNodeInfo(int val, int diameter, int pathLen) {
            this.val = val;
            this.diameter = diameter;
            this.pathLen = pathLen;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        TreeNodeInfo node = diameterOfBinaryTreeHelper(root);
        return node.diameter;
    }

    private TreeNodeInfo diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            // diamter of empty tree is -1 and path length is 0
            return new TreeNodeInfo(-1, -1, 0);
        }
        TreeNodeInfo left = diameterOfBinaryTreeHelper(root.left);
        TreeNodeInfo right = diameterOfBinaryTreeHelper(root.right);
        int leftPathLen = left.pathLen;
        int rightPathLen = right.pathLen;
        int diameter = Math.max(Math.max(left.diameter, right.diameter), leftPathLen + rightPathLen);
        int pathLen = Math.max(leftPathLen, rightPathLen) + 1;
        return new TreeNodeInfo(root.val, diameter, pathLen);
    }

    private int diameter = 0;

    public int diameterOfBinaryTree1(TreeNode root) {
        diameterOfBinaryTreeHelper1(root);
        return diameter;
    }

    private int diameterOfBinaryTreeHelper1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = diameterOfBinaryTreeHelper1(root.left);
        int rightPath = diameterOfBinaryTreeHelper1(root.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}

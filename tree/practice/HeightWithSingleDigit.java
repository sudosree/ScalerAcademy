package tree.practice;

import tree.TreeNode;

public class HeightWithSingleDigit {

    private static int heightSingleDigit(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.val < 10) {
            return 1 + Math.max(heightSingleDigit(root.left), heightSingleDigit(root.right));
        }
        return Math.max(heightSingleDigit(root.left), heightSingleDigit(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(19);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(6);
        System.out.println(heightSingleDigit(root));
    }
}

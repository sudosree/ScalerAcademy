package tree.practice;

import tree.TreeNode;

public class HeightWithEvenNodes {

    private static int findEvenHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // if even node
        if (root.val % 2 == 0) {
            return 1 + Math.max(findEvenHeight(root.left), findEvenHeight(root.right));
        }
        return Math.max(findEvenHeight(root.left), findEvenHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        System.out.println(findEvenHeight(root));
    }
}

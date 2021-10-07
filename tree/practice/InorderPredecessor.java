package tree.practice;

import tree.TreeNode;

public class InorderPredecessor {

    private static int inorderPredecessor(TreeNode root, int p) {
        TreeNode node = root;
        int predecessor = -1;
        while (node != null) {
            if (p <= node.val) {
                node = node.left;
            } else {
                predecessor = node.val;
                node = node.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(inorderPredecessor(root, 8));
    }
}
